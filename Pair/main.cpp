#include <iostream>
#include <vector>
using namespace std;

template<typename K, typename V>
class Pair {
private:
    K key;
    V value;
public:
    Pair(K key, V value) {
        this->key = key;
        this->value = value;
    }

    K getKey() const {
        return this->key;
    }

    V getValue() const {
        return this->value;
    }

    void setKey(K key) {
        this->key = key;
    }

    void setValue(V value) {
        this->value = value;
    }
};




template<typename K, typename V>
class Map {
private:
    vector<Pair<K, V>> elements;
public:

    Map(){}


    bool contains(const K& keyToFind) const {

        for (const Pair<K, V> elem : this->elements) {
            if (elem.getKey() == keyToFind)
                return true;
        }

        return false;
    }


    // Return the index of the key parameter
    // return -1 if the key is not found in the vector
    int containsIndex(const K& key) {
        if (this->isEmpty() || !this->contains(key))
            return -1;

        for (int i = 0; i < this->elements.capacity(); i++) {
            if (this->elements[i].getKey() == key)
                return i;
        }

        return -1;

    }

    int cardinalityElement(const Pair<K, V>& toFind) const {

        if (this->isEmpty())
            return 0;

        int finalCount = 0;

        for (const Pair<K, V>& elem : this->elements) {
            if (elem.getKey() == toFind.getKey())
                finalCount++;
        }

        return finalCount;
    }


    void insert(const K& key, const V& value) {


        if (this->contains(key)) {
            for (Pair<K, V>& elem : this->elements) {
                if (elem.getKey() == key)
                    elem.setValue(value);
            }
            return;
        }

        Pair<K, V> p1(key, value);
        this->elements.push_back(p1);
    }

    bool isEmpty() const {
        return this->elements.empty();
    }

    void remove(const K& key) {

        int indexToRemove = this->containsIndex(key);
        if (indexToRemove == -1)
            throw invalid_argument("Chiave non presente!");

        this->elements.erase(this->elements.begin() + indexToRemove);
    }

    void print() {
        if (this->isEmpty()) {
            cout << "Mappa vuota..." << endl;
            return;
        }

        for (Pair<K, V> elem : this->elements) {
            cout << elem.getKey() << " : " << elem.getValue() << endl;
        }
    }

    bool operator==(const Map& other) {

        if (this->isEmpty() && other.isEmpty())
            return true;
        else if (this->isEmpty() || other.isEmpty())
            return false;

        int finalCount = 0;

        for (Pair<K, V>& elem : this->elements) {
            if (other.contains(elem.getKey())) {
                if (other.cardinalityElement(elem) == this->cardinalityElement(elem))
                    finalCount++;
            }
        }

        if (finalCount == this->elements.size())
            return true;

        return false;
    }
};


int main() {


    Map<int, string> m1;
    Map<int, string> m2;
    Map<int, string> m3;

    m1.insert(1, "Ciao");
    m1.insert(69, "Yessir");
    m1.insert(1, "Sovrascritto");
    m1.remove(1);

    m2.insert(1, "Ciao");
    m2.insert(69, "Yessir");
    m2.insert(1, "Sovrascritto");
    m2.remove(1);

    m3.insert(21, "Loli");



    m1.print();

    cout << m1.operator==(m2) << endl;
    cout << m1.operator==(m3) << endl;
    cout << m2.operator==(m3) << endl;

    return 0;
}