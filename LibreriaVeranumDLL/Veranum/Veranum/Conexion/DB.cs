using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OracleClient;
using System.Data;

namespace Veranum.Conexion
{
    class DB
    {
        private OracleConnection _con;
        private OracleCommand _cmd;
        private static DB _instance;

        public DB() {
            
        }

        public static DB Instance
        {
            get {
                if (_instance == null)
                {
                    _instance = new DB();
                }
                return _instance;
            }
        }

        public bool isConectado
        {
            get { return _con.State == System.Data.ConnectionState.Open;  }
        }

        public void Conectar(string strCon)
        {
            _con = new OracleConnection(strCon);
            _con.Open();
        }

        public void Conectar(string host, int port, string service, string uid, string pw)
        {
            _con = new OracleConnection(@"Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST="+host+")(PORT="+port+"))(CONNECT_DATA=(SERVICE_NAME="+service+")));User Id="+uid+";Password="+pw);
            _con.Open();
        }

        public void Conectar(Boolean tipo)
        {
            if(tipo)
                _con = new OracleConnection(@"Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=orcl)));User Id=portafolio;Password=asd");
            else 
                _con = new OracleConnection(@"Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=portafolio;Password=asd");
            _con.Open();
        }

        public OracleCommand EjecutarQuery(string query) 
        { 
            _cmd = new OracleCommand(query, _con);
            return _cmd;
        }

        public void setParameter(string field, object objeto)
        {
            _cmd.Parameters.Add(new OracleParameter(field, objeto));
        }

        public int Procesar()
        {
            return _cmd.ExecuteNonQuery();
        }

        public OracleDataReader Reader()
        {
            return _cmd.ExecuteReader();
        }

        public int Ejecutar(string query)
        {
            if (_con == null)
            {
                return 0;
            }
            _cmd = new OracleCommand(query, _con);
            return _cmd.ExecuteNonQuery();
        }

        public DataTable Leer(string query)
        {
            DataTable _result = new DataTable();
            if (_con == null)
            {
                return null;
            }

            using(OracleDataAdapter adapter = new OracleDataAdapter(_cmd))
            {
                adapter.Fill(_result);
            }

            return _result;
        }

        public Boolean Existe(string query)
        {
            if (_con == null)
            {
                return false;
            }

            var da = new OracleDataAdapter(_cmd);
            var dt = new DataTable();
            da.Fill(dt);

            return dt.Rows.Count > 0;
        }

        public void Cerrar() {
            _con.Close();
        }
    }
}
