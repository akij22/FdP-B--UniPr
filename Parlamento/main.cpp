#include <iostream>
using namespace std;

class Partito {
protected:
    string nome;
    string sigla;
    string nomePresidente;

public:


    Partito() : Partito("", "", ""){}


    Partito(string nome, string sigla, string nomePresidente) {
        this->nome = nome;
        this->sigla = sigla;
        this->nomePresidente = nomePresidente;
    }

    string getNome() {
        return this->nome;
    }

    string getSigla() {
        return this->sigla;
    }


    string getNomePresidente() {
        return this->nomePresidente;
    }

    void setNome(const string &nome) {
        this->nome = nome;
    }

    void setSigla(const string &sigla) {
        this->sigla = sigla;
    }

    void setNomePresidente(const string &nome_presidente) {
        nomePresidente = nome_presidente;
    }

    const bool operator==(const Partito& other) const {
        return this->nome == other.nome && this->sigla == other.sigla && this->nomePresidente == other.nomePresidente;
    }
};



class PartitoDiSinistra : public Partito {
private:
    double percentualeVotoOttenuto;

public:
    PartitoDiSinistra(string nome, string sigla, string nomePresidente, double percentualeVotoOttenuto) : Partito(nome, sigla, nomePresidente) {
        if (percentualeVotoOttenuto < 0)
            throw invalid_argument("Percentuale del voto non puo' essere negativa!");

        this->percentualeVotoOttenuto = percentualeVotoOttenuto;
    }

    double getPercentualeVotoOttenuto() {
        return this->percentualeVotoOttenuto;
    }


    void setPercentualeVotoOttenuto(double voto) {
        if (voto < 0)
            throw invalid_argument("Percentuale del voto non puo' essere negativo!");
        this->percentualeVotoOttenuto = voto;
    }


};

class PartitoDiCentro : public Partito {
private:
    double percentualeVotoOttenuto;

public:
    PartitoDiCentro(string nome, string sigla, string nomePresidente, double percentualeVotoOttenuto) : Partito(nome, sigla, nomePresidente) {
        this->percentualeVotoOttenuto = percentualeVotoOttenuto;
    }

    double getPercentualeVotoOttenuto() {
        return this->percentualeVotoOttenuto;
    }


    void setPercentualeVotoOttenuto(double voto) {
        if (voto < 0)
            throw invalid_argument("Percentuale del voto non puo' essere negativo!");
        this->percentualeVotoOttenuto = voto;
    }



};

class PartitoDiDestra : public Partito {
private:
    double percentualeVotoOttenuto;

public:
    PartitoDiDestra(string nome, string sigla, string nomePresidente, double percentualeVotoOttenuto) : Partito(nome, sigla, nomePresidente) {
        this->percentualeVotoOttenuto = percentualeVotoOttenuto;
    }

    double getPercentualeVotoOttenuto() {
        return this->percentualeVotoOttenuto;
    }


    void setPercentualeVotoOttenuto(double voto) {
        if (voto < 0)
            throw invalid_argument("Percentuale del voto non puo' essere negativo!");
        this->percentualeVotoOttenuto = voto;
    }

};


class Parlamentare {
private:

    string nome;
    string cognome;
    Partito partitoAppartenenza;

public:

    Parlamentare() {

        this->nome = "";
        this->cognome = "";

    }


    Parlamentare(string nome, string cognome, Partito p) {
        this->nome = nome;
        this->cognome = cognome;
        this->partitoAppartenenza = p;
    }

    string getNome() const {
        return nome;
    }

    string getCognome() const {
        return cognome;
    }

    Partito getPartito() const {
        return this->partitoAppartenenza;
    }



    void visualizzaDettagli(ostream& out) {
        out << "Nome: " << this->nome << endl;
        out << "Cognome: " << this->cognome << endl;
        out << "Sigla del partito di appartenenza: " << this->partitoAppartenenza.getSigla() << endl;
    }

};

ostream& operator<<(ostream& out, Parlamentare& p1) {
    p1.visualizzaDettagli(out);

    return out;
}


class Parlamento {
private:
    Parlamentare* parlamentari;

    int numeroParlamentari;
    int capacity;

public:

    Parlamento() {
        this->capacity = 1;
        this->numeroParlamentari = 0;

        this->parlamentari = new Parlamentare[1];

    }

    void enLarge() {

        cout << "Sto aumentando la capienza!" << endl;

        Parlamentare* temp = new Parlamentare[this->capacity * 2];

        for (int i = 0; i < this->capacity; i++) {
            temp[i] = this->parlamentari[i];
        }

        this->parlamentari = temp;
        this->capacity = this->capacity * 2;

    }

    bool isEmpty() const {
        return this->numeroParlamentari == 0;
    }

    bool isPresent(const Parlamentare& other) const {
        if (isEmpty())
            return false;

        for (int i = 0; i < this->numeroParlamentari; i++) {
            if (this->parlamentari[i].getNome() == other.getNome() && this->parlamentari[i].getCognome() == other.getCognome()
                && this->parlamentari[i].getPartito() == other.getPartito()) {
                return true;
            }
        }

        return false;
    }


    void aggiungiParlamentare(Parlamentare& other) {
        if (isPresent(other)) {
            cout << "Parlamentare gia' presente!" << endl;
            return;
        }

        if (this->numeroParlamentari == this->capacity)
            enLarge();

        this->parlamentari[this->numeroParlamentari] = other;
        this->numeroParlamentari++;
    }


    void visualizzaParlamento() {
        for (int i = 0; i < this->numeroParlamentari; i++) {
            cout << this->parlamentari[i] << endl;
        }
    }

    void visualizzaParlamentariDi(const Partito& partito) {
        for (int i = 0; i < this->numeroParlamentari; i++) {
            if (this->parlamentari[i].getPartito() == partito)
                cout << this->parlamentari[i] << endl;
        }
    }

    ~Parlamento() {
        delete [] this->parlamentari;
    }

};

int main() {

    cout << "Benvenuto!" << endl;

    Partito partito1("Partito 1", "sigla!!!", "Achille");
    Partito partito2("Partito 2", "un'altra sigla!!!", "Giovanni");
    PartitoDiDestra pdestra1("Partito di destra 1.0", "Sigla partito di destra!!!", "Bosel", 20.5);


    Parlamentare parlamentare1("Mario", "Balotelli", partito1);
    Parlamentare parlamentare2("Steph", "Curry", partito1);
    Parlamentare parlamentare3("Lionel", "Messi", partito2);
    Parlamentare parlamentare4("Mj", "Jordan", pdestra1);

    Parlamento parlamento;

    parlamento.aggiungiParlamentare(parlamentare1);
    parlamento.aggiungiParlamentare(parlamentare2);
    parlamento.aggiungiParlamentare(parlamentare3);
    parlamento.aggiungiParlamentare(parlamentare4);

    parlamento.visualizzaParlamento();

    cout << "Parlamentari del partito di destra: " << endl;
    parlamento.visualizzaParlamentariDi(pdestra1);


    return 0;
}