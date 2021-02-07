using GestionEtudiant.models;
using GestionEtudiant.services;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GestionEtudiant
{
    public partial class FrmConnexion : Form
    {

        Service metier = new Service();

        public FrmConnexion()
        {
            InitializeComponent();
        }

       
        private void btnConnexion_Click(object sender, EventArgs e)
        {
            if(string.IsNullOrEmpty(textLogin.Text)|| string.IsNullOrEmpty(textPwd.Text))
            {
                labelError.Text = "Login ou Mot de passe Obligatoire";
                labelError.Visible = true;
            }
            else
            {
                Personne pers = metier.SeConnecter(textLogin.Text.Trim(), textPwd.Text.Trim());
                if(pers == null)
                {
                    labelError.Text = "Login ou Mot de passe Incorrecte";
                    labelError.Visible = true;
                }
                else
                {
                    FrmMenu frmMenu = new FrmMenu();
                    frmMenu.Show();
                    this.Hide();
                }
            }
        }

        private void FrmConnexion_Load(object sender, EventArgs e)
        {
            labelError.Visible = false;
        }

        private void btnAnnuler_Click(object sender, EventArgs e)
        {
            textLogin.Clear();
            textPwd.Clear();
        }

        private void FrmConnexion_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }
    }
}
