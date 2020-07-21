#include<bits/stdc++.h>
using namespace std;

int field[100001],x[100001];
int n,k,a,m,available_space,occupied_space;

bool gameOver(int shootIndex)
{

    int needed_space = k*a;
    int currentIndex = shootIndex-1;
    field[currentIndex] = 1;           //make shot index visited
    int indexToVisit = 0;              //indexToVisit is for calculating useless space which can't be occupied by ships
    int bound = currentIndex+a;

    if(bound >= n)
    {
        bound = n-1;
        indexToVisit = n-1;
    }
    else
    {
        for(int j = currentIndex+1; j <= bound; j++)
        {
            if(field[j] == 1)
                indexToVisit = j;
        }
    }
    for(int j = currentIndex+1; j <= indexToVisit; j++)
    {
        field[j] = 1;
    }

    bound = currentIndex - a;
    if(bound < 0)
    {
        bound = 0;
        indexToVisit = 0;
    }
    else
    {
        for(int j = currentIndex-1; j >= bound; j--)
        {
            if(field[j] == 1)
                indexToVisit = j;
        }
    }
    for(int j = currentIndex-1; j >= indexToVisit; j--)
    {
        field[j] = 1;
    }

    available_space+=occupied_space;
    for(int i=0; i<n; i++)
    {
        if(field[i] == 1)
            available_space--;
    }

    occupied_space = n - available_space;

    //cout<<endl<<"Avail : "<<available_space<<endl;
    if(available_space < needed_space)
    {
        return true;
    }
    else
        return false;
}


int main()
{

    cin>>n>>k>>a;

    cin>>m;

    available_space = n;
    occupied_space = 0;
    for(int i=0; i<m; i++)
    {
        cin>>x[i];
    }

    memset(field,0,sizeof(field));

    bool over = false;

    for(int i = 0; i < m; i++)
    {
        if(gameOver(x[i]) == true) //Check if game is over or not
        {
            over = true;
            cout<<i+1<<endl;
            break;
        }
    }

    if(over == false)
        cout<<"-1"<<endl;

    return 0;
}

