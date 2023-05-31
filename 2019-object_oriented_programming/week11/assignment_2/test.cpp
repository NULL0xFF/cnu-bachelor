//
// Created by 김혁진 on 2019/11/12.
//

#include "Integer.h"
#include "Float.h"
#include "Complex.h"
#include <iostream>

int main()
{
    // 이번 과제는 테스트 코드를 주지 않습니다.
    // 직접 코드를 작성해보면서 확인해보세요
    {
        Number *a = new Integer(13);
        Number *result = a->add(new Float(3.14));
        std::cout << dynamic_cast<Float *>(result)->val() << std::endl; // 16.14
    }
    {
        Number *a = new Integer(3);
        Number *result = a
                             ->add(new Float(3.14))
                             ->sub(new Integer(1))
                             ->mul(new Integer(7))
                             ->sub(new Complex(11, 5));
        std::cout << dynamic_cast<Complex *>(result)->to_string() << std::endl; // 24.980000 - 5.000000i
    }
    {
        Number *a = new Integer(20);
        Number *result = a
                             ->add(new Integer(30))
                             ->sub(new Integer(40))
                             ->mul(new Integer(50))
                             ->div(new Integer(10));
        std::cout << dynamic_cast<Integer *>(result)->to_string() << std::endl; // (((20+30)-40)*50)/10 = 50
    }
    {
        Number *a = new Float(1.2);
        Number *result = a
                             ->add(new Float(2.8))
                             ->sub(new Float(2.0))
                             ->mul(new Float(4.0))
                             ->div(new Float(3.0));
        std::cout << dynamic_cast<Float *>(result)->to_string() << std::endl; // (((1.2+2.8)-2.0)*4.0)/3.0 = 2.6667
    }
    {
        Number *a = new Complex(2.4, 1.2);
        Number *result = a
                             ->add(new Float(4))
                             ->sub(new Float(10))
                             ->mul(new Float(1.2))
                             ->div(new Float(1.2));
        std::cout << dynamic_cast<Complex *>(result)->to_string() << std::endl; // -3.6 + 1.2i
    }
    {
        Number *a = new Complex(3, -1);
        Number *result = a
                             ->div(new Complex(2, -2));
        std::cout << dynamic_cast<Complex *>(result)->to_string() << std::endl; // 1 + 0.5i
    }
    // 테스트 코드 작성해보고 확인해보세요
    // 채점은 임의의 테스트코드로 진행할 예정입니다

    return 0;
}