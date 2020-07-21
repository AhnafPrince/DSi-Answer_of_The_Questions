#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n,k,a,m;
    cin>>n>>k>>a;

    int needed_space = k*a;
    int available_space = n - needed_space;

    cin>>m;
    int x[m];

    for(int i=0; i<m; i++)
    {
        cin>>x[i];
    }

    if(available_space < m)
        cout<<available_space<<endl;
    else
        cout<<"-1"<<endl;

    return 0;
}

