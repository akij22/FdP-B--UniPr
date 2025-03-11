#include <iostream>
using namespace std;


template <typename T>
class MultiSet {
private:

    T* a;
    int dim;
    int top;

public:

    MultiSet() {
        this->a = new T[1];
        this->dim = 1;
        this->top = 0;
    }

    ~MultiSet() {
        delete[] this->a;
    }

    MultiSet(const MultiSet& other) {
        // TODO


    }

    void enLarge() {

        // cout << "Allargo dimensione dell'array..." << endl;
        T* temp = new T[this->dim * 2];

        for (int i = 0; i < this->dim; i++) {
            temp[i] = this->a[i];
        }

        this->a = temp;
        this->dim = this->dim * 2;

    }

    bool isEmpty() {
        return this->dim == 0;
    }

    void add(T x) {

        if (top == dim) {
            enLarge();
        }

        this->a[top] = x;
        this->top++;
    }

    bool contains(T x) {
        for (int i = 0; i < dim; i++)
            if (this->a[i] == x)
                return true;

        return false;
    }

    int multiplicity(T x) {
        if (this->isEmpty())
            return 0;

        int count = 0;
        for (int i = 0; i < this->dim; i++) {
            if (this->a[i] == x)
                count++;
        }

        return count;
    }

    void remove(T x) {
        if (!(this->contains(x))) {
            throw invalid_argument("Elemento non presente nell'insieme");
        }

        if (x == this->a[dim]) {
            this->dim--;
            this->top--;
            return;
        }

        for (int i = 0; i < this->dim; i++) {
            if (this->a[i] == x) {
                for (int j = i; j < dim - 1; j++) {
                    this->a[j] = this->a[j + 1];
                }

                this->dim--;
                i = 0;
            }

        }
    }

    int getDim() const {
        return this->dim;
    }

    void print(ostream& out) const {
        out << "(";

        for (int i = 0; i < this->getDim(); i++) {
            out << this->a[i];
            if (i + 1 < this->getDim())
                out << ", ";
        }

        out << ")" << endl;
    }


    //// OVERLOADING DEGLI OPERATORI ////
    MultiSet operator+(const MultiSet& other) {
        MultiSet final;


        for (int i = 0; i < this->dim; i++){
            final.add(this->a[i]);
        }

        for (int i = 0; i < other.dim; i++){
            final.add(other.a[i]);
        }

        return final;
    }

    const MultiSet& operator=(const MultiSet& other) {


        delete [] this->a;

        this->top = 0;
        this->dim = other.dim;

        for (int i = 0; i < other.dim; i++) {
            this->add(other.a[i]);
        }

        return *this;
    }

};

template<typename T>
ostream& operator<<(ostream& out, const MultiSet<T>& m1) {

    m1.print(out);

    return out;
}

int main() {

    MultiSet<int> m1;
    MultiSet<int> m2;
    MultiSet<int> final;

    MultiSet<string> stringSet;

    stringSet.add("ciao");
    stringSet.add("yessir");

    m1.add(5);
    m1.add(5);
    m1.add(10);
    m1.add(1);

    m2.add(99);
    m2.add(51);
    m2.add(22);
    m2.add(15);
    m2.add(38);



    cout << m1;

    cout << m2;

    final = m1;
    cout << final;

    cout << stringSet;

    return 0;


}