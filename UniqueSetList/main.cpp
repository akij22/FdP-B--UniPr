#include <iostream>
#include <set>
#include <list>
using namespace std;

// Implementazione di una struttura dati List, in cui gli elementi sono univoci e memorizzati in un set
template<class T>
class UniqueSetList {
private:
    list<T> l;
    set<T> unique;

public:

    UniqueSetList() {
    }

    void add(const T& x) {
        if (isAlreadyPresent(x))
            throw invalid_argument("Elemento gia' presente nella list!");

        this->l.push_back(x);
        this->unique.insert(x);

        cout << "Elemento inserito correttamente!" << endl;

    }



    void removeFront() {
        if (this->unique.empty())
            throw invalid_argument("Lista vuota!");

        T elem = this->l.front();
        this->l.pop_front();


        this->unique.erase(elem);

        cout << "Ho rimosso l'elemento in testa: " << elem << endl;

    }

    void removeTail() {
        if (this->unique.empty())
            throw invalid_argument("Lista vuota!");

        T elem = this->l.back();

        this->l.pop_back();

        this->unique.erase(elem);

        cout << "Ho rimosso l'elemento in coda: " << elem << endl;
    }

    bool isAlreadyPresent(const T& x) {

        if (this->unique.count(x) == 0)
            return false;
        return true;

    }

    void print(ostream& out) {
        for (auto elem : this->l) {
            cout << elem << " ";
        }

        cout << endl;
    }

    int size() {
        return this->l.size();
    }



};

template <class T>
ostream& operator<<(ostream& out, UniqueSetList<T>& other) {

    other.print(out);
    return out;
}




int main() {

    UniqueSetList<int> u1;

    u1.add(10);
    u1.add(20);
    u1.add(30);

    cout << u1;

    try {
        u1.add(10);
    } catch (invalid_argument i) {
        cout << i.what() << endl;
    }

    u1.removeFront();


    cout << u1;
    return 0;
}