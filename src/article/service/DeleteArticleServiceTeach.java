package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDaoTeach;
import article.dao.ArticleDaoTeach;
import article.model.Article;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import member.service.InvalidPasswordException;

public class DeleteArticleServiceTeach {
	private ArticleDaoTeach articleDao = new ArticleDaoTeach();
	private ArticleContentDaoTeach contentDao = new ArticleContentDaoTeach();
	private MemberDao memberDao = new MemberDao();

	public void delete(DeleteRequestTeach delReq) {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Article article = articleDao.selectById(conn,
					delReq.getArticleNumber());
			Member member = memberDao.selectById(conn,
					delReq.getUserId());

			if (article == null) {
				throw new ArticleNotFoundException();
			}

			if (!canModify(delReq.getUserId(), article)) {
				throw new PermissionDeniedException();
			}

			if (!delReq.getPassword()
					.equals(member.getPassword())) {
				throw new InvalidPasswordException();
			}

			articleDao.delete(conn, delReq.getArticleNumber());
			contentDao.delete(conn, delReq.getArticleNumber());
			conn.commit();
		} catch (SQLException | PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (InvalidPasswordException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean canModify(String modfyingUserId,
			Article article) {
		return article.getWriter().getId()
				.equals(modfyingUserId);
	}
}
