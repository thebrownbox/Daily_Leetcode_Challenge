#include <string>
#include <iostream>
#include <sstream>
#include <map>

using namespace std;

bool isPrime(int n)
{
    for (int i = 2; i < n; i++)
    {
        if(n % i == 0)
            return false;
    }
    return true;
}

std::string prime_consecutive( int n, int index ) {
	stringstream ss;
    int i = 0;
    int x = 2;
    int count = 0;
    while(true)
    {
        if(isPrime(x) == true)
        {
            if(i == index)
            {
                count++;
                if(count <= n)
                {
                    ss << x;
                }
                else{
                    break;
                }
                
            }

            i++;
        }
        x++;
    }
    
    return ss.str();
}

int main()
{
    cout << prime_consecutive(2,2);

    return 0;
}