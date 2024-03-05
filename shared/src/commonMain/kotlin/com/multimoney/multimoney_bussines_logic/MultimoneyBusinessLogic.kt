import com.multimoney.multimoney_bussines_logic.di.initKoin

object MultimoneyBusinessLogic {

    var SERVER_URL = "https://rickandmortyapi.com/graphql"

    fun initialization(
        baseUrl: String
    ) {
        initKoin()
        SERVER_URL = baseUrl
    }
}