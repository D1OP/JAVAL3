using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.models
{
    class Professeur:Personne
    {
        private String grade;
        private List<String> modules;
        private String matricule;

        public string Grade { get => grade; set => grade = value; }
        public List<string> Modules { get => modules; set => modules = value; }
        public string Matricule { get => matricule; set => matricule = value; }

        public Professeur(int id, String nomComplet, string grade, String matricule) : base(id,nomComplet)
        {
            this.grade = grade;
            this.matricule = matricule;
            Type = "Professeur";
        }

        public Professeur(String nomComplet, string grade, String matricule) : base(nomComplet)
        {
            this.grade = grade;
            this.matricule = matricule;
            Type = "Professeur";
        }

        public Professeur()
        {
            Type = "Professeur";
        }
    }
}
