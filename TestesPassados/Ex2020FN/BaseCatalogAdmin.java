import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class BaseCatalogAdmin implements CatalogAdmin {
    
        private Map<String, Servico> servicos;

        public BaseCatalogAdmin(){
            this.servicos = new HashMap<>();
        }
    
        public BaseCatalogAdmin(Map<String, Servico> servicos) {
            this.servicos = servicos;
        }
    
        public boolean registarServico(String codigo, Servico servico) {
            if (servicos.containsKey(codigo)) {
                return false;
            }
            servicos.put(codigo, servico);
            return true;
        }
    
        public boolean verificarServico(String codigo) {
            return servicos.containsKey(codigo);
        }
    
        public Servico selecionarServico(String codigo) {
            return servicos.get(codigo);
        }
    
        public Servico removerServico(String codigo) {
            return servicos.remove(codigo);
        }
    
        public Map<String, Servico> getServicos() {
            return servicos;
        }
    
        public Iterator<String> iterator() {
            return servicos.keySet().iterator();
        }
    
    
}