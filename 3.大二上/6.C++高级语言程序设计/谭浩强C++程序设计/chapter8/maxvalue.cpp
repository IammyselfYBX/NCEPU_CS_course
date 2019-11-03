#include <iostream>
using namespace std;
class Maxvalue
{
private:
    /* data */
    int array[10];
    int max;
public:
    void set_value();
    void max_value();
    void show_value();
};

int main()
{
    Maxvalue a;
    a.set_value();
    a.max_value();
    a.show_value();

    return 0;
}

void Maxvalue::set_value()
{
    int i = 0;
    cout << "please input some value" << endl;
    for(i = 0; i<10; i++)
    {
        cin >> array[i];
    }
}

void Maxvalue::max_value()
{   
    int i = 0;
    max =array[0];
    for(i = 1; i<10; i++)
    {
        if(array[i] > max)
        {
            max = array[i];
        }
    }
}

void Maxvalue::show_value()
{
    cout << "The max value is " << max <<endl;
}