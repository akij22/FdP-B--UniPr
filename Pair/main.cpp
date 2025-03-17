#include <iostream>
using namespace std;

template<class K, class V>
class Pair {
private:
    K first;
    V second;
public:

    K getKey() const {
        return this->first;
    }

    V& getValue() {
        return this->second;
    }

    void setValue(V v) {
        this->second = v;
    }

    void setKey(K k) {
        this->first = k;
    }
};

template<class K, class V>
class Map {
private:
    Pair<K, V>* container;
    int dim;
    int curs;

    void enlarge() {
        Pair<K,V>* new_container = new Pair<K,V>[dim * 2];
        for (int i = 0; i < this->curs; i++)
            new_container[i] = this->container[i];
        delete [] this->container;
        this->container = new_container;
        this->dim = dim * 2;
    }

public:

    Map<K, V>() {
        this->container = new Pair<K, V>[5];
        this->dim = 5;
        this->curs = 0;
    }

    Map<K, V>(const Map<K, V>& other) {
        this->dim = other.dim;
        this->curs = other.curs;
        this->container = new Pair<K, V>[dim];
        for (int i = 0; i < curs; i++)
            this->container[i] = other.container[i];
    }

    ~Map<K, V>() {
        delete [] this->container;
    }

    const Map<K,V>& operator=(const Map<K, V>& other) {
        if (this != &other) {

            delete [] this->container;
            this->dim = other.dim;
            this->curs = other.curs;
            this->container = new Pair<K, V>[dim];
            for (int i = 0; i < curs; i++)
                this->container[i] = other.container[i];
        }
        return *this;
    }

    void update(K k, V v) {
        if (!contains(k))
            throw invalid_argument("Key not present");
        for (int i = 0; i < curs; i++)
            if (this->container[i].getKey() == k)
                this->container[i].setValue(v);
    }

    void add(K k, V v) {
        if (contains(k))
            throw invalid_argument("Key-value pair already present");
        if (curs == dim)
            enlarge();

        this->container[curs].setKey(k);
        this->container[curs].setValue(v);
        this->curs++;
    }

    bool contains(K k) {
        for (int i = 0; i < curs; i++)
            if (this->container[i].getKey() == k)
                return true;
        return false;
    }

    bool isEmpty() const {
        return this->curs == 0;
    }

    void remove(K k) {
        for (int i = 0; i < curs; i++)
            if (this->container[i].getKey() == k) {
                for (int j = i; j < curs - 1; j++)
                    this->container[j] = this->container[j + 1];
                curs--;
            }
    }

    ostream& print(ostream& dest) const {
        if (isEmpty())
            cout << "Empty map" << endl;
        else
            for (int i = 0; i < this->curs; i++)
                dest << "(" << this->container[i].getKey() << ", " << this->container[i].getValue() << ")" << endl;
        return dest;
    }

    V& operator[](K k) {
        for (int i = 0; i < this->curs; i++)
            if (this->container[i].getKey() == k)
                return this->container[i].getValue();
        throw out_of_range("Key not present");
    }
};

template<class K, class V>
ostream& operator<<(ostream& dest, const Map<K, V>& map) {
    return map.print(dest);
}

int main() {
    Map<int, string> map;
    cout << map;
    map.add(1, "hello");
    map.add(2, "world");
    map.add(3, "bye");
    cout << map;

    map.remove(4);
    map.remove(2);
    cout << map;

    return 0;
}