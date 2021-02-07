using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
using GestionEtudiant.dao;
using GestionEtudiant.models;

namespace Fondamentaux
{
    class Program
    {        
        static void Main(string[] args)
        {    
            
            DaoClasse dao = new DaoClasse();
            Classe classe = new Classe()
            {
                Libelle = "GLRS3",
                NbreEtudiant=33
            };
            dao.Insert(classe);



            List<Classe> classes = dao.FindAll();
            foreach(var cl in classes)
            {
                Console.WriteLine(cl);
            }

 
        }
    }
}
