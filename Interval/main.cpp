#include <iostream>
using namespace std;

class Interval {
private:
    int e1;
    int e2;

    int find_min(Interval i1) {
        if (this->e1 < i1.e1)
            return this->e1;

        return i1.e1;
    }

    int find_max(Interval i1) {
        if (this->e2 > i1.e2)
            return this->e2;

        return i1.e2;
    }

    int find_min_multiplication(Interval i1) {

        int element1 = this->e1 * i1.e1;
        int element2 = this->e1 * i1.e2;
        int element3 = this->e2 * i1.e1;
        int element4 = this->e2 * i1.e2;

        if (element1 < element2 && element1 < element3 && element1 < element4)
            return element1;

        if (element2 < element1 && element2 < element3 && element2 < element4)
            return element2;

        if (element3 < element1 && element3 < element2 && element3 < element4)
            return element3;

        if (element4 < element1 && element4 < element2 && element4 < element3)
            return element4;
    }


    int find_max_multiplication(Interval i1) {

        int element1 = this->e1 * i1.e1;
        int element2 = this->e1 * i1.e2;
        int element3 = this->e2 * i1.e1;
        int element4 = this->e2 * i1.e2;

        if (element1 > element2 && element1 > element3 && element1 > element4)
            return element1;

        if (element2 > element1 && element2 > element3 && element2 > element4)
            return element2;

        if (element3 > element1 && element3 > element2 && element3 > element4)
            return element3;

        if (element4 > element1 && element4 > element2 && element4 > element3)
            return element4;
    }
public:

    Interval() : Interval(0, 1) {
    }

    Interval(int i, int j) {
        if (i >= 0)
            this->e1 = i;
        else {
            cout << "Valore di i non valido!" << endl;
            this->e1 = 0;
        }

        if (j > i)
            this->e2 = j;
        else {
            cout << "Valore di j non valido!" << endl;
            this->e2 = i + 1;
        }

    }

    Interval sum(const Interval& i1) const {
        Interval final;

        final.e1 = this->e1 + i1.e1;
        final.e2 = this->e2 + i1.e2;

        return final;
    }

    bool contains(int x) const {
        return x >= this->e1 && x <= this->e2;
    }

    Interval join(const Interval i1) {
        Interval final;

        final.e1 = this->find_min(i1);

        final.e2 = this->find_max(i1);

        return final;

    }

    Interval operator+(Interval& i1) {
        return this->sum(i1);
    }

    Interval operator*(Interval& i1) {
        Interval final;

        final.e1 = find_min_multiplication(i1);

        final.e2 = find_max_multiplication(i1);


        return final;
    }

    int getE1() {
        return this->e1;
    }

    int getE2() {
        return this->e2;
    }




};



ostream& operator<<(ostream& dest, Interval& i) {
    dest << "[ "<< i.getE1() << ", " << i.getE2() << " ]" << endl;

    // Ritorno lo stream di output
    return dest;
}

int main() {

    Interval i1(1, 2);
    Interval i2(5, 9);


    // Check dei controlli del costruttore
    Interval i3(5, 1);

    Interval final = i1.join(i2);

    Interval final2 = i1 * i2;

    cout << final;

    cout << final2 << endl;

    if (i2.contains(8))
        cout << "8 e' contenuto nel range!" << endl;
    else
        cout << "8 non e' contenuto nel range!" << endl;

    if (i2.contains(10))
        cout << "10 e' contenuto nel range!" << endl;
    else
        cout << "10 non e' contenuto nel range!" << endl;

    Interval sum = i1 + i2;

    cout << "La somma dei due intervalli e' " << sum << endl;

    return 0;

}
