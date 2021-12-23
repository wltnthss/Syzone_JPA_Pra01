package hellojpa;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER")
public class Member {

    // primary key 값을 알려주는 어노테이션
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Sequence값 자동으로 생성해줌
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String username;

    // FetchType -> 테이블이 분리돼서 쿼리가 나감
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member() {
    }

    public Member(Long id, String username, Team team) {
        this.id = id;
        this.username = username;
        this.team = team;
    }

    public Member(long l, String aaa) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
