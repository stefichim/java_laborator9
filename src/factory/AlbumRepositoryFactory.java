package factory;

import controllers.AlbumController;
import repo.AbstractRepository;
import repo.AlbumRepository;

public class AlbumRepositoryFactory implements RepoAbstractFactory {
    public AlbumController createRepository(String type) {
        if (type.equals("jdbc")) {
            return new controllers.AlbumController(app.AlbumManager.getDatabase());
        } else return null;
    }
}
