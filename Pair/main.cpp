#include <iostream>
using namespace std;

// CLASSE PAIR


template<typename F, typename S>

class Pair {
private:
    F first;
    S second;

public:

    F getKey() {
        return this->first;
    }

    S getSecond() {
        return this->second;
    }


    // Set del value, utilizzato per l'array dinamico (container) in Map
    void setValue(S s) {
        this->second = s;
    }

    // Set della key, utilizzato per l'array dinamico (container) in Map
    void setKey(F x) {
        this->first = x;
    }
};


template <typename F, typename S>
istream& operator>> (istream& in, Pair<F, S>& p1) {

    F chiave;
    S value;

    cout << "Inserisci chiave: ";

    in >> chiave;

    cout << "Inserisci valore: ";

    in >> value;

    if (chiave < 0)
        throw invalid_argument("Chiave non puo' essere negativa");

    p1.setKey(chiave);

    p1.setValue(value);

    return in;
}



// CLASSE MAP

template<typename F, typename S>
class Map {
private:

    // Array dinamico di coppie interi / stringhe, preso dalla class Pair
    Pair<F, S>* container;
    int dim;
    int cursor; // Numero di elementi dentro il container, prossima cella in cui inserire il prossimo Pair

public:

    Map() {
        this->container = new Pair<F, S>[5];

        this->dim = 5;
        this->cursor = 0;

    }

    Map(Pair* p1, int dim) {

        this->container = p1;

        if (dim < 0)
            throw invalid_argument("Dimensione non puo' essere negativa");

        this->dim = dim;

    }

    ~Map() {

    }

    Map(const Map& other) {

    }


    void update(int key, string value) {
        if (!contains(key)) {
            throw invalid_argument("Chiave non presente nel Map");
        }

        for (int i = 0; i < cursor; i++) {
            if (key == this->container[i].getKey()) {

                this->container[i].setValue(value);
            }
        }
    }


    void add(int key, string value) {

        if (contains(key)) {
            throw invalid_argument("Chiave gia' presente");
        }

        this->container[cursor].setKey(key);
        this->container[cursor].setValue(value);

        this->cursor++;
    }

    bool contains(int key) {

        for (int i = 0; i < cursor; i++) {
            if (key == this->container[i].getKey())
                return true;
        }

        return false;

    }

    int getDim() {
        return this->dim;
    }

    void print(ostream& out) const {
        for (int i = 0; i < this->dim; i++) {
            out << this->container[i].getKey() << " --> " << this->container[i].getSecond() << endl;
        }
    }

    Map& operator=(const Map& m1) {

        if (this == &m1)
            return *this;

        delete [] this->container;

        this->container = new Pair;

        this->dim = m1.dim;

        for (int i = 0; i < this->dim; i++) {
            this->add(m1.container[i].getKey(), m1.container[i].getSecond());
        }

        return *this;
    }

    void printContainerAddress() {
        cout << &(this->container) << endl;
    }


};

ostream& operator<<(ostream& out, const   Map& m1) {

    m1.print(out);

    return out;
}





int main() {

    Pair p1;

    Map m1;
    m1.add(1, "Ciao");
    m1.add(100, "cento");
    m1.add(2, "Lesgoski");
    m1.add(54, "Random");
    m1.add(22, "Yessir");

    Map m2;

    m2 = m1;

    cout << m1;
    cout << m2;

    m1.printContainerAddress();
    m2.printContainerAddress();



    // cin >> p1;



    return 0;
}