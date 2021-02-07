using GestionEtudiant.models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.dao
{
    class DaoPersonne : IDao<Personne>
    {

        private DaoSql sqlServer;

        public DaoPersonne()
        {
            sqlServer = new DaoSql();
        } 

        public int Insert(Personne pers)
        {
            String sql = String.Format("INSERT INTO personne(nom_complet, type, tuteur, modules, grade, matricule,classe_id)values('{0}','{1}','{2}','{3}','{4}','{5}','{6}')", pers.NomComplet, pers.Type, ((Etudiant)pers).Tuteur, models.Convert.ListToString(((Professeur)pers).Modules), ((Professeur)pers).Grade, ((Professeur)pers).Matricule, ((Etudiant)pers).Classe.Id);
            return sqlServer.ExecuteUpdate(sql);

        }

        public DataTable FindByClasse(Classe classe)
        {
            String sql = string.Format("select p.id, nom_Complet as 'Nom & Prenom', tuteur, libelle as 'Classe', nbre_Etudiant from personne p, classe cl where classe_id={0} and cl.id=p.classe_id", classe.Id);

            return sqlServer.ExecuteSelect(sql);
        }

        public List<Professeur> FindAllProfesseur()
        {
            List<Professeur> lProfesseur = new List<Professeur>();
            String sql = string.Format("select * from personne where type = 'Professeur'");
            DataTable dt = sqlServer.ExecuteSelect(sql);
            foreach (DataRow row in dt.Rows)
            {
                Professeur professeur = new Professeur();
                professeur.Id = int.Parse(row.ItemArray[0].ToString().Trim());                
                professeur.NomComplet = row.ItemArray[1].ToString().Trim();
                professeur.Type = row.ItemArray[2].ToString().Trim();                              
                lProfesseur.Add(professeur);
            }

            return lProfesseur;
        }

        public Personne FindUserConnect(String login, String pwd)
        {
            Personne pers = null;
            String sql = String.Format("select * from personne where login='{0}' and pwd='{1}'",login,pwd);

            DataTable dt = sqlServer.ExecuteSelect(sql);

            foreach (DataRow row in dt.Rows)
            {
                String type=row.ItemArray[2].ToString().Trim();
                if (type.CompareTo("Admin") == 0)
                {
                    pers = new Admin();
                }
                if (type.CompareTo("Professeur") == 0)
                {
                    pers = new Professeur()
                    {
                        Grade = row.ItemArray[4].ToString().Trim(),
                        Matricule = row.ItemArray[6].ToString().Trim(),
                        Modules = models.Convert.StringToList(row.ItemArray[5].ToString().Trim())

                };
                }
                if (type.CompareTo("Etudiant") == 0)
                {
                    pers = new Etudiant()
                    {
                        Tuteur = row.ItemArray[3].ToString().Trim()
                };
                }

                pers.Id = int.Parse(row.ItemArray[0].ToString().Trim());
                pers.NomComplet = row.ItemArray[1].ToString().Trim();


            }

            return pers;
        }


        


    }
}
