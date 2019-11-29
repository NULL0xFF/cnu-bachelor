#include "puyo.hpp"

// PuyoPuyo Game Constructor
puyo::puyo(void)
{
    this->init();
    this->score = 0;
    this->second = 0;
    this->isAlive = false;
    this->isInput = false;
}

// Initialize Visual 2D-Array with Blank character
void puyo::init(void)
{
    this->graphic_map = new std::map<int, std::map<int, object *> *>();
    // this->map = new char *[_MAP_ROW];
    for (int i = 0; i < _MAP_ROW; i++)
    {
        this->graphic_map->insert(std::make_pair(i, new std::map<int, object *>));
        // this->map[i] = new char[_MAP_COLUMN];
        for (int j = 0; j < _MAP_COLUMN; j++)
        {
            this
                ->graphic_map->find(i)
                ->second->insert(std::make_pair(j, new object(_MAP_BLANK)));
            // this->map[i][j] = '.';
        }
    }
    return;
}

// Run game sequence while isAlive flag is true
void puyo::run(void)
{
    while (isAlive)
    {
        this->draw();
        SLEEP(1);
        this->second++;
        this->update();
    }
}

// Draw game board and score on terminal
void puyo::draw(void)
{
    if (isInput)
    {
        if (input_string == _INPUT_QUIT)
        {
            this->isAlive = false;
            std::cout << "QUITING..." << std::endl;
            return;
        }

        if (input_string == _INPUT_ARROW_UP || input_string == _INPUT_ARROW_DOWN || input_string == _INPUT_ARROW_LEFT || input_string == _INPUT_ARROW_RIGHT)
        {
            this
                ->graphic_map->find(0)
                ->second->find(2)
                ->second->set_val(input_string);
        }
        isInput = false;
    }
    if (system(CLEAR) != 0)
        throw std::runtime_error("console clear failed");

    std::cout << "Score:\t" << this->score << "\tTime:\t" << this->second << std::endl;
    for (int i = 0; i < _MAP_ROW; i++)
    {
        for (int j = 0; j < _MAP_COLUMN; j++)
        {
            std::cout << this
                             ->graphic_map->find(i)
                             ->second->find(j)
                             ->second->to_string()
                      << '\t';
        }
        std::cout << std::endl;
    }
}

// Update position of items on game board while applying gravity
void puyo::update(void)
{
    if (blocked())
    {
        this->isAlive = false;
        std::cout << "Press any key to quit" << std::endl;
        return;
    }
    int _row = 0, _column = 0;
    for (_row = _MAP_ROW - 1; _row > 0; _row--)
    {
        for (_column = _MAP_COLUMN - 1; _column >= 0; _column--)
        {
            if (this
                    ->graphic_map->find(_row)
                    ->second->find(_column)
                    ->second->to_string() == _MAP_BLANK)
            {
                this
                    ->graphic_map->find(_row)
                    ->second->find(_column)
                    ->second->set_val(this->graphic_map->find(_row - 1)->second->find(_column)->second->to_string());
                this
                    ->graphic_map->find(_row - 1)
                    ->second->find(_column)
                    ->second->set_val(_MAP_BLANK);
            }
        }
    }
    return;
}

bool puyo::blocked(void)
{
    int _row = 0, _column = 0;
    bool flag = true;
    for (_column = 0; _column < _MAP_COLUMN; _column++)
    {
        flag = true;
        for (_row = 0; _row < _MAP_ROW; _row++)
        {
            if (this->graphic_map->find(_row)->second->find(_column)->second->to_string() == _MAP_BLANK)
            {
                flag = false;
                break;
            }
        }
        if (flag)
            return true;
    }
    return false;
}

// Return input if arrow key inputed
void puyo::input(void)
{
    while (true)
    {
        if (!isAlive)
            return;
        while (isInput)
        {
            // Loop until isInput flag turned to false
        }

        std::string input_str;

        /* Solution Found on stackoverflow
         * https://stackoverflow.com/questions/10463201/getch-and-arrow-codes/11432632#11432632 */
        char c = getch();
        if (c == '\033')
        {
            getch();
            switch (getch())
            {
            case 'A': // ARROW UP
                input_str = _INPUT_ARROW_UP;
                break;
            case 'B': // ARROW DOWN
                input_str = _INPUT_ARROW_DOWN;
                break;
            case 'C': // ARROW RIGHT
                input_str = _INPUT_ARROW_RIGHT;
                break;
            case 'D': // ARROW LEFT
                input_str = _INPUT_ARROW_LEFT;
                break;
            }
            isInput = true;
            input_string = input_str;
        }
        else if (c == 113)
        {
            // EXIT
            this->isInput = true;
            input_string = _INPUT_QUIT;
            this->draw();
            return;
        }
        this->draw();
    }
}

// Set isAlive flag to true and execute run() function
void puyo::start(void)
{
    this->isAlive = true;
    this->isInput = false;

    std::thread game_thread(&puyo::run, this);
    std::thread input_thread(&puyo::input, this);

    if (input_thread.joinable())
        input_thread.join();
    if (game_thread.joinable())
        game_thread.join();

    std::cout << "Your Score is " << this->second << std::endl;
    return;
}