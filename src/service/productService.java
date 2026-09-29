package service;

import java.util.LinkedHashMap;
import java.util.Map;
import model.product;

public class productService {
    private Map<Integer, product> list = new LinkedHashMap<>();

    public boolean canRegister(product product) {
        // Verifica se o ID já existe de forma instantânea pegando getid da classe produto
        if (list.containsKey(product.getId())) {
            return false; // Já existe, não cadastra
        }
                 //integer       //produto/objeto          colocados no linkedhashmap ids iguais
        list.put(product.getId(), product);
        return true; // Cadastrado com sucesso
    }

    public void listAll() {
        if (list.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        } 

        System.out.println("\n--- Lista de Produtos ---");
         // Usamos Map.Entry para iterar pelas chaves (Integer) e valores (produto) simultaneamente
        for (Map.Entry<Integer, product> entry : list.entrySet()) {
            Integer key = entry.getKey();
            product product = entry.getValue();
        
            System.out.println("Chave: " + key + 
                           " | Nome: " + product.getName() + 
                           " | Descrição: " + product.getdescription());
        }
    }

    public boolean productexists(int Id){
        if (list.containsKey(Id)){ return true; } else { return false; }
    }

    public product search(int Id){
        return list.get(Id);
    }

    public boolean updateProduct(int oldId, int newId, String newName, String newDescription){

        if (oldId != newId && list.containsKey(newId)) {
        return false; // O novo ID já está em uso por outro registo
        } else{
            //criação de novo produto
            product p = list.remove(oldId);
            p.setId(newId);
            p.setName(newName);
            p.setDescription(newDescription);

            list.put(newId, p); //insere produto e chave nova
            return true;
        }
        
    }

    public boolean deleteProduct(int id) {
    // O remove(id) apaga a chave e devolve o objeto que lá estava (ou null se não existir)
    product removido = list.remove(id);
    
    // Se for diferente de null, significa que encontrou e apagou com sucesso
    return removido != null; 
    }
  

}
    

