package factory;

import repo.AbstractRepository;

public interface RepoAbstractFactory {

    public AbstractRepository createRepository(String type);
}
