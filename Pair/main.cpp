#include <iostream>
#include <set>
using namespace std;

template<class K, class V>
class Pair {
private:
    K first;
    V second;
public:


    Pair<K ,V>(K first, V second) {

        this->first = first;
        this->second = second;
    }


    const K getKey() const {
        return this->first;
    }

    const V& getValue() const {
        return this->second;
    }

    void setValue(V v) {
        this->second = v;
    }

    void setKey(K k) {
        this->first = k;
    }

    // Necessario, in quanto la insert di SET effettua un confronto ad un certo punto del codice
    bool operator<(const Pair<K, V>& other) const {
        return this->first < other.first;
    }
};



template<class K, class V>
class Map {
private:

    // Utilizzo un set per implementare Map
    // Devo avere chiavi univoche
    vector<Pair<K, V>> container;

public:
    Map<K, V>(){}

    void add(const K key, const V value) {

        if (keys().count(key) != 0) {

            // utilizzando vector, posso andare a returnare l'iterator per reference
            for (Pair<K, V>& p : this->container) {

                if (p.getKey() == key)
                    p.setValue(value);
            }


        } else {

            // Chiave non ancora presente nel mio set, quindi la posso aggiungere per la prima volta
            this->container.push_back(Pair<K, V>(key, value));
        }

    }


    // Returna tutti i VALORI (<V>) della Map, senza considerare la rispettiva chiave
    set<V>values() {

        set<V> final;

        for (Pair<K, V> e : this->container) {
            // Inserisco in final solamente il valore del container (rinominato e nel FOREACH)
            final.insert(e.getValue());
        }

        return final;


    }

    set<K> keys() {
        set<K> final;

        for (Pair<K, V> p : this->container){
            final.insert(p.getKey());
        }

        return final;
    }

    void updateAllValues(V v) {
        for (Pair <K, V> p : this->container) {
            p.setValue(v);
        }
    }


    void print(ostream& out) const {

        for (Pair<K, V> p : this->container) {
            cout << p.getKey() << " " << p.getValue() << endl;
        }

        cout << endl;
    }
};

template<class K, class V>
ostream& operator<<(ostream& out, const Map<K, V>& m1) {

    m1.print(out);
    return out;

}



int main() {

    Map<int, int> m1;

    m1.add(1, 10);
    m1.add(2, 20);
    m1.add(3, 30);

    // Check dell' effettiva modifica
    m1.add(1, 55);

    cout << m1;


}