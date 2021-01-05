package com.quarkus;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@DBRider
@QuarkusTest
@QuarkusTestResource(DatabaseTestResource.class)
public class ProdutoTest {


    @Test
    @DataSet("produtos1.yml")
    public void testeUm(){
        Assertions.assertEquals(1, Produto.count());
    }

}