#include<bits/stdc++.h>
using namespace std;

int main()
{
    unsigned long long n;
    cin>>n;

    int ans = 0;

    while(n != 0)
    {
        if(n%2 == 0)
            n/=2;

        else
        {
            n--;
            ans++;
        }
    }

    cout<<ans<<endl;

    return 0;
}

