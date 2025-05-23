#include <iostream>
using namespace std;


class Persona {
protected:
    string nome;
    string cognome;
    string codiceFiscale;

public:

    Persona() {
        this->nome = "";
        this->cognome = "";
        this->codiceFiscale = "XXXXXXXXXXXXXXXX";
    }

    Persona(string nome, string cognome, string codiceFiscale) {
        this->nome = nome;
        this->cognome = cognome;

        if (codiceFiscale.length() == 16)
            // Necessiterebbe ulteriori controlli...
            this->codiceFiscale = codiceFiscale;
        else throw invalid_argument("Codice fiscale non valido!");
    }

    string getNome() const {
        return this->nome;
    }

    string getCognome() const {
        return this->cognome;
    }

    string getCodiceFiscale() const {
        return this->codiceFiscale;
    }

    void visualizzaDettagli(ostream& out) const {
        out << "Nome: " << this->getNome() << ", cognome: " << this->getCognome() << ", codice fiscale: " << this->getCodiceFiscale() << endl;
    }

    bool operator==(const Persona& other) {
        return this->getCodiceFiscale() == other.getCodiceFiscale();
    }

    bool isDocente() {
        return false;
    }

};

ostream& operator<<(ostream& out, const Persona& p) {
    p.visualizzaDettagli(out);

    return out;
}


class Studente : public Persona {
private:
    int matricola;
    string corsoDiLaurea;
    double mediaVoti;

public:

    Studente() : Persona() {
        this->matricola = 0;
        this->corsoDiLaurea = "";
        this->mediaVoti = 0.0;
    }

    Studente(string nome, string cognome, string codiceFiscale, int matricola, string corsoDiLaurea,double mediaVoti) : Persona(nome, cognome, codiceFiscale) {
        this->matricola = matricola;
        this->corsoDiLaurea = corsoDiLaurea;
        if (mediaVoti >= 0)
            this->mediaVoti =mediaVoti;
        else throw invalid_argument("Media voti non valida!");
    }

    int getMatricola() const {
        return matricola;
    }

    void setMatricola(const int matricola) {
        this->matricola = matricola;
    }

    string getCorsoDiLaurea() const {
        return corsoDiLaurea;
    }

    void setCorsoDiLaurea(const string &corso_di_laurea) {
        corsoDiLaurea = corso_di_laurea;
    }

    double getMediaVoti() const {
        return mediaVoti;
    }

    void setMediaVoti(const double media_voti) {
        if (media_voti > 0)
            mediaVoti = media_voti;
        else throw invalid_argument("Media voti non valida!");
    }

    void visualizzaDettagli(ostream& out) const {
        Persona :: visualizzaDettagli(out);

        out << "Numero di matricola: " << this->getMatricola() << ", corso di laurea: " << this->getCorsoDiLaurea() << ", media voti: " << this->getMediaVoti() << endl;
    }
};

ostream& operator<<(ostream& out, const Studente& s) {
    s.visualizzaDettagli(out);

    return out;
}


class Docente : public Persona {
private:
    string dipartimento;
    string materiaInsegnata;
public:

    Docente() : Persona() {
        this->dipartimento = "";
        this->materiaInsegnata = "";
    }

    Docente(string nome, string cognome, string codiceFiscale, string dipartimento, string materiaInsegnata) : Persona(nome, cognome, codiceFiscale) {
        this->dipartimento = dipartimento;
        this->materiaInsegnata = materiaInsegnata;
    }


    string get_dipartimento() const {
        return dipartimento;
    }

    void set_dipartimento(const string &dipartimento) {
        this->dipartimento = dipartimento;
    }

    string get_materia_insegnata() const {
        return materiaInsegnata;
    }

    void set_materia_insegnata(const string &materia_insegnata) {
        materiaInsegnata = materia_insegnata;
    }


    void visualizzaDettagli(ostream& out) {
        Persona :: visualizzaDettagli(out);

        out << "Dipartimento: " << this->get_dipartimento() << ", materia insegnata: " << this->get_materia_insegnata() << endl;
    }


    bool isDocente() {
        return true;
    }
};

ostream& operator<<(ostream& out, Docente& d) {
    d.visualizzaDettagli(out);

    return out;
}


class Universita {
private:
    vector<Persona> persone;

public:

    Universita() {

    }

    void aggiungiPersona(Persona& p) {
        persone.push_back(p);
    }

    bool isEmpty() {
        return persone.empty();
    }

    bool isPresent(Persona& toFind) {
        for (Persona& p : persone) {
            if (p == toFind)
                return true;
        }
        return false;
    }

    void stampa(ostream& out) {
        for (Persona& elem : persone) {
            out << elem;
        }
    }


};

int main() {

    Persona p1("Achille", "Rossi", "Codice fiscale 1");
    Persona p2("Mario", "Bianchi", "Codice fiscale 2");

    Docente d1("Michael", "Jordan", "Codice fiscale 3", "Chicago Bully", "Golf");


    Universita u1;

    u1.aggiungiPersona(p1);
    u1.aggiungiPersona(p2);

    u1.aggiungiPersona(d1);

    u1.stampa(cout);

    return 0;
}