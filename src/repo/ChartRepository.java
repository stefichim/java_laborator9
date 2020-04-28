package repo;

import entity.Chart;

public class ChartRepository extends AbstractRepository<Chart> {

    public ChartRepository() {
        super();
    }

    public Chart findById(int id) {
        return entityManager.find(Chart.class, id);
    }

}
