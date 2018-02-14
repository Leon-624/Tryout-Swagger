package org.liyanxu.tryoutswagger;

import com.fasterxml.jackson.databind.SerializationFeature;
import io.dropwizard.Application;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.liyanxu.tryoutswagger.api.api.TryoutSwaggerApi;
import org.liyanxu.tryoutswagger.resources.TryoutSwaggerResource;
import org.liyanxu.tryoutswagger.service.TryoutSwaggerApiImpl;
import zone.dragon.dropwizard.HK2Bundle;
import javax.inject.Singleton;

public class TryoutSwaggerApplication extends Application<TryoutSwaggerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TryoutSwaggerApplication().run(args);
    }

    @Override
    public String getName() {
        return "TryoutSwagger";
    }

    @Override
    public void initialize(final Bootstrap<TryoutSwaggerConfiguration> bootstrap) {

        // This ensures there's only ever one HK2 bundle; don't use bootstrap.addBundle(new HK2Bundle<>());
        HK2Bundle.addTo(bootstrap);

        // Add Swagger Bundle
        bootstrap.addBundle(new SwaggerBundle<TryoutSwaggerConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(TryoutSwaggerConfiguration config) {
                return config.getSwaggerBundleConfiguration();
            }
        });

        // Customize global JSON serialization settings
        bootstrap.getObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    public void run(final TryoutSwaggerConfiguration configuration,
                    final Environment env) {

        JerseyEnvironment jersey = env.jersey();

        jersey.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(TryoutSwaggerApiImpl.class).to(TryoutSwaggerApi.class).in(Singleton.class);
            }
        });

        jersey.register(TryoutSwaggerResource.class);
    }

}
