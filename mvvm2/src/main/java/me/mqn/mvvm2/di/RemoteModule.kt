package me.mqn.mvvm2.di

// @Module
// @InstallIn(SingletonComponent::class)
object RemoteModule {

	// @Named(Constants.Name.BASEURL)
	// @Provides
	// @Singleton
	// fun provideBaseUrl() = "BuildConfig.BASE_URL"
	//    fun provideBaseUrl() = Api.BASE_URL

	// @Named(Constants.Name.CONNECTION_TIMEOUT)
	// @Provides
	// @Singleton
	// fun provideConnectionTimeout() = "Api.CONNECTION_TIMEOUT"

	// @Named(Constants.Name.PING_INTERVAL)
	// @Provides
	// @Singleton
	// fun providePingInterval() = "Api.PING_INTERVAL"

	/** Lenient *//*     @Provides
        @Singleton
        fun provideGsonLenient(): Gson = GsonBuilder().setLenient().create() */

	/** Interceptor *//*     @Singleton
        @Provides
        fun provideAuthInterceptor(
            @ApplicationContext context: Context,
            sessionManager: SessionManager,
        ): AuthInterceptor = AuthInterceptor(context, sessionManager) */

	/** Authenticator *//* @Singleton
    @Provides
    fun provideAuthAuthenticator(
        sessionManager: SessionManager,
        authApiService: AuthApiService,
    ): AuthAuthenticator =
        AuthAuthenticator(sessionManager, authApiService) */

	/** level body*//* @Provides
    @Singleton
    fun provideBodyInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BASIC
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
        } */

	/* @Provides
	@Singleton
	fun provideChucker(@ApplicationContext context: Context): Interceptor {
		// Config Chucker
		val chuckerCollector = ChuckerCollector(
			context = context,
			// Toggles visibility of the push notification
			showNotification = true,
			// Allows to customize the retention period of collected data
			//            retentionPeriod = RetentionManager.Period.ONE_HOUR
		)
		return ChuckerInterceptor.Builder(context)
			// The previously created Collector
			.collector(chuckerCollector)
			// The max body content length in bytes, after this responses will be truncated.
			.maxContentLength(250_000L)
			// List of headers to replace with ** in the Chucker UI
			.redactHeaders(Api.AUTHORIZATION)
			// Read the whole response body even when the client does not consume the response completely.
			// This is useful in case of parsing errors or when the response body
			// is closed before being read like in Retrofit with Void and Unit types.
			.alwaysReadResponseBody(true)
			// Use decoder when processing request and response bodies.
			// When multiple decoders are installed they are applied in an order they were added.
			//            .addBodyDecoder(decoder)
			// Controls Android shortcut creation. Available in SNAPSHOTS versions only at the moment
			//            .createShortcut(true)
			.build()
	} */

	/** config okhttp client*//* @Provides
    @Singleton
    fun provideOkhttpClient(
        @Named(Constants.Name.CONNECTION_TIMEOUT) timeout: Long,
        @Named(Constants.Name.PING_INTERVAL) ping: Long,
        //        tokenManager: TokenManager,
        authInterceptor: AuthInterceptor,
        //        authAuthenticator: AuthAuthenticator,
        chuckerInterceptor: Interceptor,
        body: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
             *//*.addInterceptor { chain ->
                    val token = runBlocking { tokenManager.fetchToken().first().toString() }
                    chain.proceed(
                        request = chain.request().newBuilder().also {
                            it.addHeader(Api.AUTHORIZATION, "${Api.PREFIX_JWT_TOKEN}$token")
                            it.addHeader(Constants.ACCEPT, Constants.APPLICATION_JSON)
                            it.addHeader(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                        }.build()
                    )
                }.also { client ->
                    client.addInterceptor(body)
                    client.addInterceptor(ChuckerInterceptor)
                }*//*
            //     okhttp integration sentry integration
            .eventListener(eventListener = SentryOkHttpEventListener())
            .addInterceptor(
                interceptor = SentryOkHttpInterceptor(
                    captureFailedRequests = true,
                    // By default, only HTTP client errors with a response code between 500 and 599 are captured as error events
                    failedRequestStatusCodes = listOf(
                        HttpStatusCodeRange(400, 599),
                    ),
                    // HTTP client errors from every target (.* regular expression)
                    // failedRequestTargets = listOf("myapi.com")
                ),
            )
            .addInterceptor(interceptor = body)
            .addInterceptor(interceptor = chuckerInterceptor)
            .addInterceptor(interceptor = authInterceptor)
            //        .authenticator(authAuthenticator)
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            //            .retryOnConnectionFailure(true)
            .pingInterval(
                interval = ping,
                unit = TimeUnit.SECONDS,
            )
            .protocols(listOf(Protocol.HTTP_1_1)) // todo: fix error wms wifi
            .build()
    } */

	/** RetrofitBuilder*//* @Provides
    @Singleton
    fun provideRetrofitBuilder(
        @Named(Constants.Name.BASEURL) baseUrl: String,
        gson: Gson,
        okHttpClient: OkHttpClient,
    ): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson)) */

	/** AuthAPIService*//* @Provides
    @Singleton
    fun provideAuthAPIService(retrofit: Retrofit.Builder): AuthApiService =
        retrofit.build().create(AuthApiService::class.java) */

	/** APIService*//* @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit.Builder): ApiService =
        retrofit.build().create(ApiService::class.java) */

	/* @Provides
	@Singleton
	fun provideInventoryAPIService(retrofit: Retrofit.Builder): InventoryApiService =
		retrofit.build().create(InventoryApiService::class.java) */
}

// object NetworkModule

// @Module
// @InstallIn(SingletonComponent::class)
// class NetworkModule {

/*
	@Provides
	fun provideHttpClient(): HttpClient =
		MiniTalesHttpClientBuilder()
			.protocol(URLProtocol.HTTP)
			.host(BuildConfig.MINI_TALES_HOST)
			.port(8080)
			.build() */

/* @Provides
fun provideRequestHandler(client: HttpClient) = RequestHandler(client) */
// }