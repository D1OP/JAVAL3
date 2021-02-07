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
    public partial class Form1 : Form
    {

        private Service metier = new Service();

        public Form1()
        {
            InitializeComponent();
        }

        private void btnAjouter_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(textLibelle.Text) || string.IsNullOrEmpty(textNbreEtudiant.Text))
            {
                MessageBox.Show("Libelle ou Nbre Etudiant obligatoire",
                    "Message Erreur",
                MessageBoxButtons.OK,
                MessageBoxIcon.Error);
            }
            else
            {
                Classe classe = new Classe()
                {
                    Libelle=textLibelle.Text.Trim(),
                    NbreEtudiant=int.Parse(textNbreEtudiant.Text.Trim())
                };

                if (metier.CreerClasse(classe))
                {
                    MessageBox.Show("Classe ajoutée avec succès",
                   "Message Information",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Information);

                    textLibelle.Clear();
                    textNbreEtudiant.Clear();

                    LoadDataGridView();
                }

            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            LoadDataGridView();
        }

        private void LoadDataGridView()
        {
            dtgvClasse.DataSource = metier.ListerClasse();
        }

        private void dtgvClasse_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            
        }

        private void dtgvClasse_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            DataGridViewRow row = dtgvClasse.Rows[e.RowIndex];
            row.Selected = true;
            int id = int.Parse(row.Cells[0].Value.ToString());
            Classe classe = new Classe()
            {
                Id = id
            };

            dtgvEtudiant.DataSource = metier.ListerEtudiantParClasse(classe);

        }
    }
}
