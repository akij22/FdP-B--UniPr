#include <iostream>
using namespace std;


template<typename T>
class Multiset {
private:
    T* elements;
    int dim;
    int pos;

public:
    Multiset() {
        this->pos = 0;
        this->dim = 2;
        this->elements = new T[2];
    }

    void enLarge() {
        T* newArray = new T[this->dim * 2];
        this->dim *= 2;

        for (int i = 0; i < this->pos; i++) {
            newArray[i] = this->elements[i];
        }

        delete [] this->elements;
        this->elements = newArray;
    }

    void add(const T value) {
        if (this->pos == this->dim - 1)
            this->enLarge();

        this->elements[this->pos] = value;
        this->pos++;
    }

    bool isEmpty() const {
        return this->pos == 0;
    }


    bool contains(const T value) const {
        if (this->isEmpty())
            return false;

        for (int i = 0; i < this->pos; i++) {
            if (this->elements[i] == value)
                return true;
        }

        return false;
    }

    int cardinality(const T& value) const {
        if (this->isEmpty())
            return 0;

        int finalCounter = 0;

        for (int i = 0; i < this->pos; i++) {
            if (this->elements[i] == value)
                finalCounter++;
        }

        return finalCounter;
    }


    Multiset<T> intersection(const Multiset<T>& other) {
        // if (this->isEmpty() || other.isEmpty())


        Multiset finalM;

        for (int i = 0; i < this->pos; i++) {
            if (other.contains(this->elements[i])) {
                int cMin = this->cardinality(this->elements[i]) < other.cardinality(this->elements[i]) ? this->cardinality(this->elements[i]) :
                    other.cardinality(this->elements[i]);

                if (!finalM.contains(this->elements[i])) {
                    for (int j = 0; j < cMin; j++) {
                        finalM.add(this->elements[i]);
                    }
                }
            }
        }

        return finalM;
    }

    void print() {
        for (int i = 0; i < this->pos; i++) {
            cout << this->elements[i] << " ";
        }

        cout << endl;
    }

    // COSTRUTTORE DI COPIA
    Multiset(const Multiset<T>& other) {
        this->dim = other.dim;
        this->pos = other.pos;
        T* newArray = new T[this->dim];

        for (int i = 0; i < this->dim; i++) {
            newArray[i] = other.elements[i];
        }

        this->elements = newArray;

    }


    // OVERLOADING OPERATORE DI ASSEGNAMENTO
    Multiset& operator=(const Multiset<T>& other) {
        this->dim = other.dim;
        this->pos = other.pos;

        delete [] this->elements;
        T* newArray = new T[other.dim];

        for (int i = 0; i < this->dim; i++) {
            newArray[i] = other.elements[i];
        }

        this->elements = newArray;
        return *this;
    }

    ~Multiset() {
        delete [] this->elements;
    }
};


int main() {
    Multiset<int> m1;
    Multiset<int> m2;

    m1.add(51);
    m1.add(51);
    m1.add(22);
    m1.add(69);
    m1.add(22);

    m2.add(51);
    m2.add(51);
    m2.add(51);
    m2.add(22);
    m2.add(44);

    Multiset<int> copy(m1);

    copy = m2;


    Multiset<int> intersectionM = m1.intersection(m2);

    m1.print();
    copy.print();

    intersectionM.print();

    return 0;
}