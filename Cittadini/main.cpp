#include <iostream>
using namespace std;

class Data {
protected:
    int g;
    int m;
    int a;

private:
    bool controlla_Data() {
        if (g <= 0) return false;
        if (m <= 0 || m > 12) return false;
        if (a < 0) return false;
        //...
        return true;
    }

public:
    Data() {
        g = 1;
        m = 1;
        a = 0;
    }

    Data(int giorno, int mese, int anno) {
        g = giorno;
        m = mese;
        a = anno;
        if (controlla_Data() == false)
            throw "Data non valida";
    }

    int get_giorno() {
        return g;
    }

    int get_mese() {
        return m;
    }

    int get_anno() {
        return a;
    }

    bool operator==(Data d) {
        return (g == d.g && m == d.m && a == d.a);
    }

    bool operator<(Data d) {
        return (a < d.a
        || (a == d.a && m < d.m)
        || (a == d.a && m == d.m && g < d.g));
    }

    void stampa(ostream& dest) {
        dest << g << '/' << m << '/' << a;
        return;
    }

    void leggi(istream& sorg) {
        sorg >> g >> m >> a;
        if (sorg.fail())
            throw "errore sintattico";
        if (controlla_Data() == false) {
            g = m = a = 0;
            throw "Data non valida";
        }
        return;
    }


};

ostream& operator<<(ostream& out, Data& d1) {
    d1.stampa(out);

    return out;


}


class Cittadino {
protected:

    string nome;
    string cognome;
    int eta;

public:

    Cittadino() {
        this->nome = "";
        this->cognome = "";
        this->eta = 0;
    }

    Cittadino(string nome, string cognome, int eta) {
        this->nome = nome;
        this->cognome = cognome;

        if (eta > 0)
            this->eta = eta;
        else throw invalid_argument("Eta non valida!");
    }

    void visualizzaDettagli(ostream& out) {
        cout << "Nome: " << this->nome << endl;
        cout << "Cognome: " << this->cognome << endl;
        cout << "Eta': " << this->eta << endl;
    }

    string getNome() {
        return this->nome;
    }

    string getCognome() {
        return this->cognome;
    }

    int getEta() {
        return this->eta;
    }
};

ostream& operator<<(ostream& out, Cittadino& c1) {
    c1.visualizzaDettagli(out);
    return out;
}

class Residente : public Cittadino {

    private:
    string comuneResidenza;

public:
    Residente(string nome, string cognome, int eta, string comune) : Cittadino(nome, cognome, eta) {
        this->comuneResidenza = comune;
    }

    void visualizzaDettagli(ostream& out) {
        Cittadino :: visualizzaDettagli(out);

        out << "Comune di residenza: " << this->comuneResidenza << endl;
    }
};


ostream& operator<<(ostream& out, Residente& r1) {
    r1.visualizzaDettagli(out);

    return out;
}

class Visitatore: public Cittadino {
private:

    Data dataArrivo;

public:
    Visitatore(string nome, string cognome, int eta, Data dataArrivo) : Cittadino(nome, cognome, eta) {
        this->dataArrivo = dataArrivo;
    }

    void visualizzaDettagli(ostream& out) {
        Cittadino :: visualizzaDettagli(out);

        out << "Data di arrivo: " << this->dataArrivo << endl;
    }
};

ostream& operator<<(ostream& out, Visitatore& v1) {
    v1.visualizzaDettagli(out);

    return out;
}


class Stato {
private:

    Cittadino* cittadini;

    // Indica numero di cittadini registrati fino a quel momento
    int cittadiniRegistrati;

    // Indica capienza massima
    int capacity;

public:

    Stato() {
        this->cittadiniRegistrati = 0;

        capacity = 1;

        this->cittadini = new Cittadino[1];
    }

    ~Stato() {
        delete[] this->cittadini;
    }


    bool isEmpty() {
        return this->cittadiniRegistrati == 0;

    }
    void enLarge() {

        cout << "Sto aumentando la capienza!" << endl;

        Cittadino* temp = new Cittadino[this->capacity * 2];

        for (int i = 0; i < this->capacity; i++) {
            temp[i] = this->cittadini[i];
        }

        this->cittadini = temp;
        this->capacity = this->capacity * 2;

    }

    bool isPresent(Cittadino& other) {
        if (this->isEmpty())
            return false;


        for (int i = 0; i < this->cittadiniRegistrati; i++) {
            if (this->cittadini[i].getNome() == other.getNome() && this->cittadini[i].getCognome() == other.getCognome()
                && this->cittadini[i].getEta() == other.getEta())
                return true;
        }
        return false;
    }

    void aggiungi(Cittadino& cittadino) {

        if (this->isPresent(cittadino)) {
            cout << "Cittadino gia' presente!" << endl;
            return;
        }

        if (this->capacity == this->cittadiniRegistrati)
            this->enLarge();

        this->cittadini[this->cittadiniRegistrati] = cittadino;
        this->cittadiniRegistrati++;
    }

    void print(ostream& out) {
        for (int i = 0; i < this->cittadiniRegistrati; i++) {
            out << this->cittadini[i] << endl;
        }
    }

    int getCittadiniRegistrati() const {
        return cittadiniRegistrati;
    }

    int getCapacity() const {
        return capacity;
    }
};


ostream& operator<<(ostream& out, Stato& s1) {
    s1.print(out);
    return out;
}

int main() {

    Data d1(22, 4, 2029);

    Cittadino c1("Achille", "Rossi", 19);
    Cittadino c2("Caterina", "Simonazzi", 10);
    Cittadino c3("Roberta", "Bondenari", 44);

    Visitatore v1("Dora", "L'esploratrice", 88, d1);

    Residente r1("Barbara", "Bruschi", 21, "Novellara");


    Stato s1;

    s1.aggiungi(c1);
    s1.aggiungi(c2);
    s1.aggiungi(c3);
    s1.aggiungi(v1);
    s1.aggiungi(r1);

    s1.aggiungi(r1);


    cout << s1 << endl;

    cout << s1.getCapacity() << endl;
    cout << s1.getCittadiniRegistrati() << endl;


    return 0;
}