using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.models
{
    class Convert
    {
        public static string ListToString(List<String> modules)
        {
            String moduleString = " ";
            foreach(var elt in modules)
            {
                moduleString += elt + ";";
            }
            return moduleString;
        }

        public static List<String> StringToList(String modules)
        {
            return modules.Split(';').ToList();
        }

    }
}
