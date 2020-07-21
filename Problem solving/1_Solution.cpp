#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin>>n;

    char alphabet[n+1],ans;
    int frequency[25], flag = 0;

    memset(frequency,0,sizeof(frequency));     //Initialize all elements as 0

    for(int i=0; i<n; i++)                     //taking input & checking if new character already exists
    {
        cin>>alphabet[i];

        int temp = alphabet[i] - 'a' ;
        frequency[temp]++;

        if(frequency[temp] > 1 && flag == 0)
        {
            ans = alphabet[i];
            flag = 1;
        }
    }

    if(flag == 0)
        cout<<"-1"<<endl;
    else
        cout<<ans<<endl;

    return 0;
}
