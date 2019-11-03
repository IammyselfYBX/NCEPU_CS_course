#include <string>
#include <iostream>
using namespace std;
class Student
{
    public :
        Student (int n, string nam, char s)
        {
            num  = n;
            name = nam;
            sex = s;
            cout << "Constructor called"<< endl;
        }
        ~Student()
        {
            cout<< "Destructor called" << endl;
        }
        void display()
        {
            cout << "num: "<< num << endl;
            cout << "name: "<< name << endl;
            cout << "sex: "<< sex << endl << endl;
        }
        private:
            int num;
            string name;
            char sex;
};

int main()
{
    Student stu1(1010,"ybx", 'f');
    stu1.display();
    Student stu2(1011,"hsh", 'f');
    stu2.display();

    return 0;
}