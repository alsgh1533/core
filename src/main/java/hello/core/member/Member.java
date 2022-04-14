package hello.core.member;

public class Member {

    private Long id; //  하이버네이트의 영속성 관련 문서를 보면, primitive 대신 nullable (객체)값을 사용하도록 권장하고 있습니다. 그래서 엔티티의 필드는 WrapperClass를 사용하시는것이 좋습니다.
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
