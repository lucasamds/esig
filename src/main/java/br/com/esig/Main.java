package br.com.esig;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.esig.app");


        EntityManager entidade = entityManagerFactory.createEntityManager();
/*
        //****Removendo elemento
        Tarefa tarefas = null;
        try
        {
            tarefas = entidade.find(Tarefa.class, 2L);

            entidade.getTransaction().begin();
            entidade.remove(tarefas);
            entidade.getTransaction().commit();
        }
        catch(Exception e)
        {
            entidade.getTransaction().rollback();
        }
        finally {
            entidade.close();
        }
*/
/*
        //****Editar elemento
        Tarefa tarefas = null;
        try
        {
            tarefas = entidade.find(Tarefa.class, 1L);
            tarefas.setTitulo("Mudei o titulo");
            tarefas.setDescricao("Mudei aqui tbm");

            entidade.getTransaction().begin();
            entidade.merge(tarefas);
            entidade.getTransaction().commit();
        }
        catch(Exception e)
        {
            entidade.getTransaction().rollback();
        }
        finally {
            entidade.close();
        }*/


        //****Selecionar elementos que contenham um texto indicado

        List<Tarefa> tarefas = null;
        String s = "Mudei%";
        try
        {
            tarefas = entidade.createQuery("from Tarefa t where t.titulo = :texto").setParameter("texto",s).getResultList();
        }
        catch(Exception e)
        {
            System.out.println("LIST ALL" + e.getMessage());
        }
        finally {
            entidade.close();
        }
        if(tarefas != null)
        {
            tarefas.forEach(System.out::println);
        }

 /*
        //****Selecionar pelo indice
        Tarefa tarefas = null;
        try
        {
            tarefas = entidade.find(Tarefa.class, 1L);
            System.out.println(tarefas.getTitulo()+" "+tarefas.getPrioridade() );
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            entidade.close();
        }*/

        //*****Adicionar elemento
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setTitulo("Testando o banco");
        tarefa1.setDescricao("Apenas testando o banco pela primeira vez");
        tarefa1.setPrioridade(Prioridade.BAIXA);
        tarefa1.setResponsavel("Lucas");
        Date aux = new Date();


        //Criação do Entity Manager
        //EntityManager entidade = entityManagerFactory.createEntityManager();

        //Tentando iniciar uma nova transação e persistir um valor
        try{
            entidade.getTransaction().begin();
            entidade.persist(tarefa1);
            entidade.getTransaction().commit();
        }
        catch (Exception e)
        {
            entidade.getTransaction().rollback();
            System.out.println("INSERT: " + e.getMessage());
        }
        finally {
            entidade.close();
        }
    }
}
