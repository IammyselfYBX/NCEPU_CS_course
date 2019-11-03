#include <iostream>
using namespace std;
class Time
{
    public:
        Time()  //构造方法
        {
            hour = 0;
            minute = 0;
            sec = 0;
        }
        void set_time();
        void show_time();
    private:
        int hour;        int minute;
        int sec;
};

void Time::set_time()
{
    cout<< "Please input time" << endl;
    cin >> hour >> minute>> sec;
}

void Time::show_time()
{
    cout << "Time is : " <<hour << ":"<< minute <<":" << sec<< endl;
}

int main()
{
    Time t;
    t.set_time();
    t.show_time();
    cout<<"------------------------------------------------"<< endl;
    Time t2;
    t2.show_time();

    return 0;
}