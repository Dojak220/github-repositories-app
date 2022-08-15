package br.com.dio.app.repositories.data.repositories

import android.os.RemoteException
import br.com.dio.app.repositories.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImpl(private val service: GitHubService) : RepoRepository {
    override suspend fun listRepositories(user: String) = flow {
        try {
            val repositoryList = service.listRepositories(user)
            emit(repositoryList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message)
        }

    }
}