package br.com.esig;

import jakarta.persistence.EntityManager;
import java.util.List;

public class TarefasDao {

    public void inserir(Tarefa t) throws Exception
    {
        EntityManager entidade = JpaRBean.getEntityManagerFactory().createEntityManager();

        try{
            entidade.getTransaction().begin();
            entidade.persist(t);
            entidade.getTransaction().commit();
        }
        catch (Exception e)
        {
            entidade.getTransaction().rollback();
            throw new Exception(e);
        }
        finally {
            entidade.close();
        }
    }

    public void excluir(long indice) throws Exception
    {
        EntityManager entidade = JpaRBean.getEntityManagerFactory().createEntityManager();
        try
        {
            Tarefa t = entidade.find(Tarefa.class, indice);
            entidade.getTransaction().begin();
            entidade.remove(t);
            entidade.getTransaction().commit();
        }
        catch(Exception e)
        {
            entidade.getTransaction().rollback();
            throw new Exception(e);
        }
        finally {
            entidade.close();
        }
    }

    public void atualizar(Tarefa t) throws Exception
    {
        EntityManager entidade = JpaRBean.getEntityManagerFactory().createEntityManager();

        try
        {
            entidade.getTransaction().begin();
            entidade.merge(t);
            entidade.getTransaction().commit();
        }
        catch(Exception e)
        {
            entidade.getTransaction().rollback();
            throw new Exception(e);
        }
        finally {
            entidade.close();
        }
    }

    public Tarefa selecionarIndice(long indice)
    {
        EntityManager entidade = JpaRBean.getEntityManagerFactory().createEntityManager();
        Tarefa t = entidade.find(Tarefa.class, indice);
        entidade.close();
        return t;
    }

    public List<Tarefa> selecionarTituloDescricao(String busca)
    {
        EntityManager entidade = JpaRBean.getEntityManagerFactory().createEntityManager();
        List<Tarefa> tarefas = null;
        tarefas = entidade.createQuery("from Tarefa t where t.titulo = :val OR t.descricao = :val").setParameter("val", busca).getResultList();
        entidade.close();
        return tarefas;
    }

    public List<Tarefa> selecionarResponsavel(String responsavel)
    {
        EntityManager entidade = JpaRBean.getEntityManagerFactory().createEntityManager();
        List<Tarefa> tarefas = null;
        tarefas = entidade.createQuery("from Tarefa t where t.responsavel = :val").setParameter("val", responsavel).getResultList();
        entidade.close();
        return tarefas;
    }
    public List<Tarefa> selecionarSituacao(String busca)
    {
        EntityManager entidade = JpaRBean.getEntityManagerFactory().createEntityManager();
        List<Tarefa> tarefas = null;
        tarefas = entidade.createQuery("from Tarefa t where t.titulo = :val").setParameter("val", busca).getResultList();
        entidade.close();
        return tarefas;
    }

}
