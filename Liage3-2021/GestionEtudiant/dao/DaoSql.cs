using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.dao
{
    class DaoSql
    {
        private SqlConnection con;
        private SqlCommand cmd;
        private SqlDataAdapter da;

        public DaoSql()
        {
            con = new SqlConnection();
            cmd = new SqlCommand();
            da = new SqlDataAdapter();
        }

        public void OuvrirConnexionBD()
        {
            if (con.State == ConnectionState.Closed || con.State== ConnectionState.Broken)
            {
                con.ConnectionString = @"Data Source=DIOP; Initial Catalog=gestion;Integrated Security=True ";
                con.Open();
            }
        }

        public void FermerConnexionBD()
        {
            if (con.State == ConnectionState.Open ||con.State==ConnectionState.Connecting)
            {
                con.Close();
            }
        }

        public int ExecuteUpdate(string sql)
        {
            int nbreLigne = 0;

            OuvrirConnexionBD();

                cmd.Connection = con;
                cmd.CommandText = sql;

                nbreLigne=cmd.ExecuteNonQuery();

            FermerConnexionBD();

            return nbreLigne;
        }

        public DataTable ExecuteSelect (string sql)
        {
            OuvrirConnexionBD();

                cmd.Connection = con;
                cmd.CommandText = sql;
                DataSet ds = new DataSet();
                da.SelectCommand = cmd;
                da.Fill(ds, "result");
                           
            FermerConnexionBD();

            return ds.Tables["result"];  
        }
    }
}
