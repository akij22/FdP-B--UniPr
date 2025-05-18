#include <iostream>
using namespace std;


// Creo una classe templatica
template <typename T>
class Stack {
private:
    T* a;
    int top;
    int cap;

    void enlarge() {
        T* tmp = new T[cap * 2];
        for (int i = 0; i < cap; i++)
            tmp[i] = this->a[i];
        this->cap = this->cap * 2;
        delete [] a;

        // Il puntatore a ora punta al nuovo array di dimensione doppia
        this->a = tmp;
    }

public:

    ~Stack() {
        // dealloco il puntatore che punta alla zona di memoria nello heap
        delete [] a;
    }

    Stack() {

        // Alloco un array di tipi T
        this->a = new T[5];
        this->top = 0;
        this->cap = 5;
    }


    // COSTRUTTORE DI COPIA
    // Parameter: constant reference
    Stack(const Stack& other)  {

        this->cap = other.cap;
        this->top = other.top;

        this->a = new T[this->cap];

        for (int i = 0; i < other.cap; i++) {
            this->a[i] = other.a[i];
        }

    }

    bool isEmpty() const {
        return top == 0;
    }

    void push(T x) {

        // Se ho raggiunto la dimensione massima, aumento prima la capienza
        if (top == cap)
            enlarge();

        this->a[top] = x;
        top++;
    }

    T pop() {
        if (isEmpty())
            throw out_of_range("Empty stack");
        top--;
        return this->a[top];
    }

    T getTop() const {
        if (isEmpty())
            throw out_of_range("Empty stack");
        return this->a[this->top - 1];
    }

    void print(ostream& dest) const {
        dest << "[";

        for (int i = 0; i < top; i++) {
            dest << this->a[i];
            if (i != top -1)
                dest << ", ";
        }

        dest << "]";
    }

    // Ritorno per constant reference
    const Stack& operator=(const Stack& other) {


        // Devo controllare che non puntino allo stesso oggetto,
        // ossia che NON SIANO LO STESSO OGGETTO
        if (this == &other)
            return *this;

        // E' uguale a delete [] a
        // Essendo che è chiamato in modo esplicito,
        // elimina solo l'array dinamico e non esegue una
        // deallocazione completa dell'oggetto
        this->~Stack();


        this->cap = other.cap;
        this->top = other.top;

        this->a = new T[this->cap];

        for (int i = 0; i < other.cap; i++) {
            this->a[i] = other.a[i];
        }

        return *this;

    }

};


template<typename T>
ostream& operator<<(ostream& dest, const Stack<T>& st) {
    st.print(dest);
    return dest;
}



int main() {

    Stack<int> s1;

    s1.push(5);
    s1.push(4);
    s1.push(91);
    s1.push(92);
    s1.push(93);

    Stack<int> s2;

    s2.push(10);
    s2.push(20);
    s2.push(10);
    s2.push(40);
    s2.push(50);
    s2.push(50);
    s2.push(50);
    s2.push(50);

    cout << "PRIMA DELL'ASSEGNAMENTO:" << endl;

    cout << s1 << endl;
    cout << s2 << endl;

    cout << "DOPO L'ASSEGNAMENTO:" << endl;

    s2 = s1;

    cout << s1 << endl;

    cout << "TOP s1: ";
    cout << s1.getTop() << endl;

    cout << "TOP s2: ";
    cout << s2 << endl;

    cout << s1.getTop() << endl;

    Stack<float> s3;

    s3.push(5.1);

    cout << s3 << endl;


    Stack <int>sFinal(s1);
    cout << sFinal << endl;
    cout << s1 << endl;


}

