#include "puyo.hpp"

char getch(void)
{
    char buf = 0;
    struct termios old;
    fflush(stdout);
    if (tcgetattr(0, &old) < 0)
        perror("tcsetattr()");
    old.c_lflag &= ~ICANON;
    old.c_lflag &= ~ECHO;
    old.c_cc[VMIN] = 1;
    old.c_cc[VTIME] = 0;
    if (tcsetattr(0, TCSANOW, &old) < 0)
        perror("tcsetattr ICANON");
    if (read(0, &buf, 1) < 0)
        perror("read()");
    old.c_lflag |= ICANON;
    old.c_lflag |= ECHO;
    if (tcsetattr(0, TCSADRAIN, &old) < 0)
        perror("tcsetattr ~ICANON");
    return buf;
}

int kbhit(void)
{
    struct termios oldt, newt;
    int ch;
    tcgetattr(STDIN_FILENO, &oldt);
    newt = oldt;
    newt.c_lflag &= ~(ICANON | ECHO);
    tcsetattr(STDIN_FILENO, TCSANOW, &newt);
    ch = getchar();
    tcsetattr(STDIN_FILENO, TCSANOW, &oldt);
    return ch;
}

Puyo::Puyo(int w, int h)
{
    if (w < 3 || h < 3)
        std::runtime_error("game board size must be at least 3");
    width = w;
    height = h;
    canvas = nullptr;
    t_main = nullptr;
    t_input = nullptr;
}
void Puyo::run(void)
{
    // Main loop
    while (true)
    {
        // Update
        if (!canvas->update())
            break;
        // Output
        canvas->clear();
        std::cout << "Score:\t" << canvas->getScore() << std::endl;
        canvas->draw();
        // Sleep
        std::this_thread::sleep_for(std::chrono::nanoseconds(1000000000));
    }

    // Exit thread
    isAlive = false;
    std::cout << "Press any key to quit" << std::endl;
}
void Puyo::input(void)
{
    // Main loop
    while (isAlive)
    {
        // Input
        int ch = kbhit();

        // Check condition
        if (!isAlive)
            break;

        // Case by Case
        switch (ch)
        {
        case 'A':
        case 'a':
            // Left
            canvas->move(-1, 0);
            break;
        case 'S':
        case 's':
            // Down
            canvas->move(0, 1);
            break;
        case 'D':
        case 'd':
            // Right
            canvas->move(1, 0);
            break;
        case 'Q':
        case 'q':
            // Anti-Clockwise rotation
            canvas->rotate(270);
            break;
        case 'E':
        case 'e':
            // Clockwise rotation
            canvas->rotate(90);
            break;
        case 'X':
        case 'x':
            // Gravity
            canvas->gravity_max();
            break;
        case 27: // ESC, Exit the game
            isAlive = false;
            pthread_t pt_main = t_main->native_handle();
            t_main->detach();
            pthread_cancel(pt_main);
            break;
        }

        // Output
        canvas->clear();
        std::cout << "Score:\t" << canvas->getScore() << std::endl;
        canvas->draw();
    }
}
void Puyo::reset(void)
{
    if (isAlive)
        std::runtime_error("thread is still running");

    if (canvas != nullptr)
        delete (canvas);
    canvas = new Visual(width, height);
    if (t_input != nullptr)
        delete (t_input);
}
void Puyo::start(void)
{
    if (isAlive)
        std::runtime_error("thread is already running");

    // Run thread
    reset();
    isAlive = true;
    t_main = new std::thread(&Puyo::run, this);
    t_input = new std::thread(&Puyo::input, this);
}
void Puyo::wait(void)
{
    if (t_input->joinable())
        t_input->join();
    else
        std::runtime_error("thread is not joinable");
}
