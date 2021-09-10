#include <iostream>
#include <string>

using namespace std;


class Human
{
protected:
    int age;
    string name;

public:
    Human(/* args */){
    }
    ~Human(){
    }
    virtual void sayHi(){
        cout << "Hi from Human!" << endl;
    }
};


class Student : public Human
{
private:
    /* data */
public:
    Student(int age, string name){
        this->age = age;
        this->name = name;
    }

    ~Student(){
    }

    void sayHi() override{
        cout << "Hi from Student!" << endl;
    }

    void update(int age){
        this->age = age;
    }

    void update(string name){
        this->name = name;
    }

    void show(){
        cout << this->name << " " << this->age << endl;
    }
};


int main(int argc, char const *argv[])
{
    // Override
    Human *p = new Student(10, "Cong");
    p->sayHi();

    // Overloaded
    Student* s = (Student*)p;
    s->show();
    s->update(20);
    s->update("Jack");
    s->show();
    
    delete p;
    return 0;
}

