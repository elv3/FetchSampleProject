package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final ConverterLibraryAccessors laccForConverterLibraryAccessors = new ConverterLibraryAccessors(owner);
    private final HiltLibraryAccessors laccForHiltLibraryAccessors = new HiltLibraryAccessors(owner);
    private final LoggingLibraryAccessors laccForLoggingLibraryAccessors = new LoggingLibraryAccessors(owner);
    private final NavigationLibraryAccessors laccForNavigationLibraryAccessors = new NavigationLibraryAccessors(owner);
    private final OkhttpLibraryAccessors laccForOkhttpLibraryAccessors = new OkhttpLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
     * with version reference <b>junit</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getJunit() {
        return create("junit");
    }

    /**
     * Dependency provider for <b>material</b> with <b>com.google.android.material:material</b> coordinates and
     * with version reference <b>material</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMaterial() {
        return create("material");
    }

    /**
     * Dependency provider for <b>retrofit</b> with <b>com.squareup.retrofit2:retrofit</b> coordinates and
     * with version reference <b>retrofit</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getRetrofit() {
        return create("retrofit");
    }

    /**
     * Dependency provider for <b>timber</b> with <b>com.jakewharton.timber:timber</b> coordinates and
     * with version reference <b>timber</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTimber() {
        return create("timber");
    }

    /**
     * Group of libraries at <b>androidx</b>
     */
    public AndroidxLibraryAccessors getAndroidx() {
        return laccForAndroidxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>converter</b>
     */
    public ConverterLibraryAccessors getConverter() {
        return laccForConverterLibraryAccessors;
    }

    /**
     * Group of libraries at <b>hilt</b>
     */
    public HiltLibraryAccessors getHilt() {
        return laccForHiltLibraryAccessors;
    }

    /**
     * Group of libraries at <b>logging</b>
     */
    public LoggingLibraryAccessors getLogging() {
        return laccForLoggingLibraryAccessors;
    }

    /**
     * Group of libraries at <b>navigation</b>
     */
    public NavigationLibraryAccessors getNavigation() {
        return laccForNavigationLibraryAccessors;
    }

    /**
     * Group of libraries at <b>okhttp</b>
     */
    public OkhttpLibraryAccessors getOkhttp() {
        return laccForOkhttpLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeLibraryAccessors laccForAndroidxComposeLibraryAccessors = new AndroidxComposeLibraryAccessors(owner);
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxEspressoLibraryAccessors laccForAndroidxEspressoLibraryAccessors = new AndroidxEspressoLibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);
        private final AndroidxWorkLibraryAccessors laccForAndroidxWorkLibraryAccessors = new AndroidxWorkLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>appcompat</b> with <b>androidx.appcompat:appcompat</b> coordinates and
         * with version reference <b>appcompat</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAppcompat() {
            return create("androidx.appcompat");
        }

        /**
         * Dependency provider for <b>junit</b> with <b>androidx.test.ext:junit</b> coordinates and
         * with version reference <b>junitVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("androidx.junit");
        }

        /**
         * Group of libraries at <b>androidx.compose</b>
         */
        public AndroidxComposeLibraryAccessors getCompose() {
            return laccForAndroidxComposeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.core</b>
         */
        public AndroidxCoreLibraryAccessors getCore() {
            return laccForAndroidxCoreLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.espresso</b>
         */
        public AndroidxEspressoLibraryAccessors getEspresso() {
            return laccForAndroidxEspressoLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.lifecycle</b>
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() {
            return laccForAndroidxLifecycleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.work</b>
         */
        public AndroidxWorkLibraryAccessors getWork() {
            return laccForAndroidxWorkLibraryAccessors;
        }

    }

    public static class AndroidxComposeLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeMaterial3LibraryAccessors laccForAndroidxComposeMaterial3LibraryAccessors = new AndroidxComposeMaterial3LibraryAccessors(owner);
        private final AndroidxComposeUiLibraryAccessors laccForAndroidxComposeUiLibraryAccessors = new AndroidxComposeUiLibraryAccessors(owner);

        public AndroidxComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>bom</b> with <b>androidx.compose:compose-bom</b> coordinates and
         * with version reference <b>androidx.compose.bom</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBom() {
            return create("androidx.compose.bom");
        }

        /**
         * Dependency provider for <b>foundation</b> with <b>androidx.compose.foundation:foundation</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFoundation() {
            return create("androidx.compose.foundation");
        }

        /**
         * Dependency provider for <b>runtime</b> with <b>androidx.compose.runtime:runtime</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRuntime() {
            return create("androidx.compose.runtime");
        }

        /**
         * Group of libraries at <b>androidx.compose.material3</b>
         */
        public AndroidxComposeMaterial3LibraryAccessors getMaterial3() {
            return laccForAndroidxComposeMaterial3LibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.compose.ui</b>
         */
        public AndroidxComposeUiLibraryAccessors getUi() {
            return laccForAndroidxComposeUiLibraryAccessors;
        }

    }

    public static class AndroidxComposeMaterial3LibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxComposeMaterial3LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>material3</b> with <b>androidx.compose.material3:material3</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.compose.material3");
        }

        /**
         * Dependency provider for <b>window</b> with <b>androidx.compose.material3:material3-window-size-class</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWindow() {
            return create("androidx.compose.material3.window");
        }

    }

    public static class AndroidxComposeUiLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeUiUiLibraryAccessors laccForAndroidxComposeUiUiLibraryAccessors = new AndroidxComposeUiUiLibraryAccessors(owner);

        public AndroidxComposeUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.compose.ui.ui</b>
         */
        public AndroidxComposeUiUiLibraryAccessors getUi() {
            return laccForAndroidxComposeUiUiLibraryAccessors;
        }

    }

    public static class AndroidxComposeUiUiLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeUiUiToolingLibraryAccessors laccForAndroidxComposeUiUiToolingLibraryAccessors = new AndroidxComposeUiUiToolingLibraryAccessors(owner);

        public AndroidxComposeUiUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.compose.ui.ui.tooling</b>
         */
        public AndroidxComposeUiUiToolingLibraryAccessors getTooling() {
            return laccForAndroidxComposeUiUiToolingLibraryAccessors;
        }

    }

    public static class AndroidxComposeUiUiToolingLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxComposeUiUiToolingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>tooling</b> with <b>androidx.compose.ui:ui-tooling</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.compose.ui.ui.tooling");
        }

        /**
         * Dependency provider for <b>preview</b> with <b>androidx.compose.ui:ui-tooling-preview</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPreview() {
            return create("androidx.compose.ui.ui.tooling.preview");
        }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.core:core-ktx</b> coordinates and
         * with version reference <b>coreKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.core.ktx");
        }

    }

    public static class AndroidxEspressoLibraryAccessors extends SubDependencyFactory {

        public AndroidxEspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>androidx.test.espresso:espresso-core</b> coordinates and
         * with version reference <b>espressoCore</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("androidx.espresso.core");
        }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleRuntimeLibraryAccessors laccForAndroidxLifecycleRuntimeLibraryAccessors = new AndroidxLifecycleRuntimeLibraryAccessors(owner);

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.lifecycle.runtime</b>
         */
        public AndroidxLifecycleRuntimeLibraryAccessors getRuntime() {
            return laccForAndroidxLifecycleRuntimeLibraryAccessors;
        }

    }

    public static class AndroidxLifecycleRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.lifecycle:lifecycle-runtime-compose</b> coordinates and
         * with version reference <b>lifecycleRuntimeCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.lifecycle.runtime.compose");
        }

    }

    public static class AndroidxWorkLibraryAccessors extends SubDependencyFactory {
        private final AndroidxWorkRuntimeLibraryAccessors laccForAndroidxWorkRuntimeLibraryAccessors = new AndroidxWorkRuntimeLibraryAccessors(owner);

        public AndroidxWorkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.work.runtime</b>
         */
        public AndroidxWorkRuntimeLibraryAccessors getRuntime() {
            return laccForAndroidxWorkRuntimeLibraryAccessors;
        }

    }

    public static class AndroidxWorkRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxWorkRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.work:work-runtime-ktx</b> coordinates and
         * with version reference <b>workRuntimeKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.work.runtime.ktx");
        }

    }

    public static class ConverterLibraryAccessors extends SubDependencyFactory {

        public ConverterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>gson</b> with <b>com.squareup.retrofit2:converter-gson</b> coordinates and
         * with version reference <b>converterGson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGson() {
            return create("converter.gson");
        }

    }

    public static class HiltLibraryAccessors extends SubDependencyFactory {
        private final HiltAndroidLibraryAccessors laccForHiltAndroidLibraryAccessors = new HiltAndroidLibraryAccessors(owner);
        private final HiltExtLibraryAccessors laccForHiltExtLibraryAccessors = new HiltExtLibraryAccessors(owner);
        private final HiltNavigationLibraryAccessors laccForHiltNavigationLibraryAccessors = new HiltNavigationLibraryAccessors(owner);

        public HiltLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compiler</b> with <b>com.google.dagger:hilt-android-compiler</b> coordinates and
         * with version reference <b>hilt</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompiler() {
            return create("hilt.compiler");
        }

        /**
         * Group of libraries at <b>hilt.android</b>
         */
        public HiltAndroidLibraryAccessors getAndroid() {
            return laccForHiltAndroidLibraryAccessors;
        }

        /**
         * Group of libraries at <b>hilt.ext</b>
         */
        public HiltExtLibraryAccessors getExt() {
            return laccForHiltExtLibraryAccessors;
        }

        /**
         * Group of libraries at <b>hilt.navigation</b>
         */
        public HiltNavigationLibraryAccessors getNavigation() {
            return laccForHiltNavigationLibraryAccessors;
        }

    }

    public static class HiltAndroidLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public HiltAndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>android</b> with <b>com.google.dagger:hilt-android</b> coordinates and
         * with version reference <b>hilt</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("hilt.android");
        }

        /**
         * Dependency provider for <b>testing</b> with <b>com.google.dagger:hilt-android-testing</b> coordinates and
         * with version reference <b>hilt</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTesting() {
            return create("hilt.android.testing");
        }

    }

    public static class HiltExtLibraryAccessors extends SubDependencyFactory {

        public HiltExtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compiler</b> with <b>androidx.hilt:hilt-compiler</b> coordinates and
         * with version reference <b>hiltExt</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompiler() {
            return create("hilt.ext.compiler");
        }

        /**
         * Dependency provider for <b>work</b> with <b>androidx.hilt:hilt-work</b> coordinates and
         * with version reference <b>hiltExt</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWork() {
            return create("hilt.ext.work");
        }

    }

    public static class HiltNavigationLibraryAccessors extends SubDependencyFactory {

        public HiltNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.hilt:hilt-navigation-compose</b> coordinates and
         * with version reference <b>hiltNavigationCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("hilt.navigation.compose");
        }

    }

    public static class LoggingLibraryAccessors extends SubDependencyFactory {

        public LoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>interceptor</b> with <b>com.squareup.okhttp3:logging-interceptor</b> coordinates and
         * with version reference <b>loggingInterceptor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getInterceptor() {
            return create("logging.interceptor");
        }

    }

    public static class NavigationLibraryAccessors extends SubDependencyFactory {
        private final NavigationDynamicLibraryAccessors laccForNavigationDynamicLibraryAccessors = new NavigationDynamicLibraryAccessors(owner);
        private final NavigationFragmentLibraryAccessors laccForNavigationFragmentLibraryAccessors = new NavigationFragmentLibraryAccessors(owner);
        private final NavigationRuntimeLibraryAccessors laccForNavigationRuntimeLibraryAccessors = new NavigationRuntimeLibraryAccessors(owner);
        private final NavigationUiLibraryAccessors laccForNavigationUiLibraryAccessors = new NavigationUiLibraryAccessors(owner);

        public NavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.navigation:navigation-compose</b> coordinates and
         * with version reference <b>nav.version</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("navigation.compose");
        }

        /**
         * Dependency provider for <b>testing</b> with <b>androidx.navigation:navigation-testing</b> coordinates and
         * with version reference <b>nav.version</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTesting() {
            return create("navigation.testing");
        }

        /**
         * Group of libraries at <b>navigation.dynamic</b>
         */
        public NavigationDynamicLibraryAccessors getDynamic() {
            return laccForNavigationDynamicLibraryAccessors;
        }

        /**
         * Group of libraries at <b>navigation.fragment</b>
         */
        public NavigationFragmentLibraryAccessors getFragment() {
            return laccForNavigationFragmentLibraryAccessors;
        }

        /**
         * Group of libraries at <b>navigation.runtime</b>
         */
        public NavigationRuntimeLibraryAccessors getRuntime() {
            return laccForNavigationRuntimeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>navigation.ui</b>
         */
        public NavigationUiLibraryAccessors getUi() {
            return laccForNavigationUiLibraryAccessors;
        }

    }

    public static class NavigationDynamicLibraryAccessors extends SubDependencyFactory {
        private final NavigationDynamicFeaturesLibraryAccessors laccForNavigationDynamicFeaturesLibraryAccessors = new NavigationDynamicFeaturesLibraryAccessors(owner);

        public NavigationDynamicLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>navigation.dynamic.features</b>
         */
        public NavigationDynamicFeaturesLibraryAccessors getFeatures() {
            return laccForNavigationDynamicFeaturesLibraryAccessors;
        }

    }

    public static class NavigationDynamicFeaturesLibraryAccessors extends SubDependencyFactory {

        public NavigationDynamicFeaturesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>fragment</b> with <b>androidx.navigation:navigation-dynamic-features-fragment</b> coordinates and
         * with version reference <b>nav.version</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFragment() {
            return create("navigation.dynamic.features.fragment");
        }

    }

    public static class NavigationFragmentLibraryAccessors extends SubDependencyFactory {

        public NavigationFragmentLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.navigation:navigation-fragment-ktx</b> coordinates and
         * with version reference <b>nav.version</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("navigation.fragment.ktx");
        }

    }

    public static class NavigationRuntimeLibraryAccessors extends SubDependencyFactory {

        public NavigationRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.navigation:navigation-runtime-ktx</b> coordinates and
         * with version reference <b>nav.version</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("navigation.runtime.ktx");
        }

    }

    public static class NavigationUiLibraryAccessors extends SubDependencyFactory {

        public NavigationUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.navigation:navigation-ui-ktx</b> coordinates and
         * with version reference <b>nav.version</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("navigation.ui.ktx");
        }

    }

    public static class OkhttpLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public OkhttpLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>okhttp</b> with <b>com.squareup.okhttp3:okhttp</b> coordinates and
         * with version reference <b>okhttp</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("okhttp");
        }

        /**
         * Dependency provider for <b>urlconnection</b> with <b>com.squareup.okhttp3:okhttp-urlconnection</b> coordinates and
         * with version reference <b>okhttpUrlconnection</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getUrlconnection() {
            return create("okhttp.urlconnection");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AndroidxVersionAccessors vaccForAndroidxVersionAccessors = new AndroidxVersionAccessors(providers, config);
        private final NavVersionAccessors vaccForNavVersionAccessors = new NavVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>agp</b> with value <b>8.7.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAgp() { return getVersion("agp"); }

        /**
         * Version alias <b>appcompat</b> with value <b>1.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAppcompat() { return getVersion("appcompat"); }

        /**
         * Version alias <b>composeCompiler</b> with value <b>2.0.20</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeCompiler() { return getVersion("composeCompiler"); }

        /**
         * Version alias <b>converterGson</b> with value <b>2.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getConverterGson() { return getVersion("converterGson"); }

        /**
         * Version alias <b>coreKtx</b> with value <b>1.15.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoreKtx() { return getVersion("coreKtx"); }

        /**
         * Version alias <b>espressoCore</b> with value <b>3.6.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getEspressoCore() { return getVersion("espressoCore"); }

        /**
         * Version alias <b>hilt</b> with value <b>2.49</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHilt() { return getVersion("hilt"); }

        /**
         * Version alias <b>hiltExt</b> with value <b>1.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHiltExt() { return getVersion("hiltExt"); }

        /**
         * Version alias <b>hiltNavigationCompose</b> with value <b>1.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHiltNavigationCompose() { return getVersion("hiltNavigationCompose"); }

        /**
         * Version alias <b>junit</b> with value <b>4.13.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit() { return getVersion("junit"); }

        /**
         * Version alias <b>junitVersion</b> with value <b>1.2.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunitVersion() { return getVersion("junitVersion"); }

        /**
         * Version alias <b>kotlin</b> with value <b>2.0.20</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlin() { return getVersion("kotlin"); }

        /**
         * Version alias <b>lifecycleRuntimeCompose</b> with value <b>2.8.7</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycleRuntimeCompose() { return getVersion("lifecycleRuntimeCompose"); }

        /**
         * Version alias <b>loggingInterceptor</b> with value <b>4.12.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLoggingInterceptor() { return getVersion("loggingInterceptor"); }

        /**
         * Version alias <b>material</b> with value <b>1.12.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMaterial() { return getVersion("material"); }

        /**
         * Version alias <b>okhttp</b> with value <b>4.12.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getOkhttp() { return getVersion("okhttp"); }

        /**
         * Version alias <b>okhttpUrlconnection</b> with value <b>4.4.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getOkhttpUrlconnection() { return getVersion("okhttpUrlconnection"); }

        /**
         * Version alias <b>retrofit</b> with value <b>2.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRetrofit() { return getVersion("retrofit"); }

        /**
         * Version alias <b>timber</b> with value <b>5.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTimber() { return getVersion("timber"); }

        /**
         * Version alias <b>workRuntimeKtx</b> with value <b>2.10.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWorkRuntimeKtx() { return getVersion("workRuntimeKtx"); }

        /**
         * Group of versions at <b>versions.androidx</b>
         */
        public AndroidxVersionAccessors getAndroidx() {
            return vaccForAndroidxVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.nav</b>
         */
        public NavVersionAccessors getNav() {
            return vaccForNavVersionAccessors;
        }

    }

    public static class AndroidxVersionAccessors extends VersionFactory  {

        private final AndroidxComposeVersionAccessors vaccForAndroidxComposeVersionAccessors = new AndroidxComposeVersionAccessors(providers, config);
        public AndroidxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.androidx.compose</b>
         */
        public AndroidxComposeVersionAccessors getCompose() {
            return vaccForAndroidxComposeVersionAccessors;
        }

    }

    public static class AndroidxComposeVersionAccessors extends VersionFactory  {

        public AndroidxComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>androidx.compose.bom</b> with value <b>2024.12.01</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBom() { return getVersion("androidx.compose.bom"); }

    }

    public static class NavVersionAccessors extends VersionFactory  {

        public NavVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>nav.version</b> with value <b>2.8.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getVersion() { return getVersion("nav.version"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final AndroidPluginAccessors paccForAndroidPluginAccessors = new AndroidPluginAccessors(providers, config);
        private final ComposePluginAccessors paccForComposePluginAccessors = new ComposePluginAccessors(providers, config);
        private final KotlinPluginAccessors paccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>hilt</b> with plugin id <b>com.google.dagger.hilt.android</b> and
         * with version reference <b>hilt</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getHilt() { return createPlugin("hilt"); }

        /**
         * Plugin provider for <b>kapt</b> with plugin id <b>org.jetbrains.kotlin.kapt</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getKapt() { return createPlugin("kapt"); }

        /**
         * Group of plugins at <b>plugins.android</b>
         */
        public AndroidPluginAccessors getAndroid() {
            return paccForAndroidPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.compose</b>
         */
        public ComposePluginAccessors getCompose() {
            return paccForComposePluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.kotlin</b>
         */
        public KotlinPluginAccessors getKotlin() {
            return paccForKotlinPluginAccessors;
        }

    }

    public static class AndroidPluginAccessors extends PluginFactory {

        public AndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>android.application</b> with plugin id <b>com.android.application</b> and
         * with version reference <b>agp</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getApplication() { return createPlugin("android.application"); }

    }

    public static class ComposePluginAccessors extends PluginFactory {

        public ComposePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>compose.compiler</b> with plugin id <b>org.jetbrains.kotlin.plugin.compose</b> and
         * with version reference <b>composeCompiler</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getCompiler() { return createPlugin("compose.compiler"); }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>kotlin.android</b> with plugin id <b>org.jetbrains.kotlin.android</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getAndroid() { return createPlugin("kotlin.android"); }

    }

}
