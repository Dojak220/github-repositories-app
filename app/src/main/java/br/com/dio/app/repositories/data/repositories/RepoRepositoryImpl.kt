package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.data.services.GitHubService
import kotlinx.coroutines.flow.flow

class RepoRepositoryImpl(private val service: GitHubService) : RepoRepository {
    override suspend fun listRepositories(user: String) = flow {
        val repositoryList = service.listRepositories(user)
        emit(repositoryList)
    }
}