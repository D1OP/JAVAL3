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
    public partial class FrmListerProfesseur : Form
    {
        public FrmListerProfesseur()
        {
            InitializeComponent();
        }

        private Service metier = new Service();

        private void FrmListerProfesseur_Load(object sender, EventArgs e)
        {
            LoadDataGridView();

            cmbClasse.DataSource = metier.ListerClasse();
            cmbClasse.DisplayMember = "libelle";
            cmbClasse.ValueMember = "id";
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void LoadDataGridView()
        {
            dtgvProfesseur.DataSource = metier.ListerProfesseur();
        }
    }
}
