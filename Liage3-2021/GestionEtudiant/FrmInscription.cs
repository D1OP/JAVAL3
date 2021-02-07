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
    public partial class FrmInscription : Form
    {
        private Service metier = new Service();

        public FrmInscription()
        {
            InitializeComponent();
        }        

        private void FrmInscription_Load(object sender, EventArgs e)
        {
            cmbClasse.DataSource = metier.ListerClasse();
            cmbClasse.DisplayMember = "libelle";
            cmbClasse.ValueMember = "id";
        }

        private void btnAnnuler_Click(object sender, EventArgs e)
        {
            textNomComplet.Clear();
            textTuteur.Clear();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(textNomComplet.Text) || string.IsNullOrEmpty(textTuteur.Text))
            {
                MessageBox.Show("Champs Obligatoires",
                "Erreur", MessageBoxButtons.OK, MessageBoxIcon.Error);            
            }
            else
            {
                Etudiant etu = new Etudiant()
                {
                    NomComplet = textNomComplet.Text.Trim(),
                    Tuteur = textTuteur.Text.Trim()
                };

                if (metier.CreerEtudiant(personne))
                {
                    MessageBox.Show("Etudiant ajoutée avec succès",
                   "Message Information",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Information);

                    textNomComplet.Clear();
                    textTuteur.Clear();                  
                }
        }        
    }
}
