/**
 * EnumConstants.java com.jiajiao.core.common.enums Copyright (c) 2015,
 * 北京微课九天教育科技有限公司版权所有.
 */

package site.lovecode.wechat.support.enums;


/**
 * 数据字典中所有枚举类型定义
 * <p>
 * 
 * 在实际运用当中，可能存在有相同字段名称的枚举，但枚举值不一致，故我们枚举类型取名规则如下：
 * 	 1.以去掉前缀的表名为起始前缀，为避免枚举名称太长去掉了表名中的"_"，
 * 	 2.再以of为中缀，
 *   3.再以字段为后缀。
 *   4.同时在枚举类上方增加枚举说明及枚举所支持的表名称，以支持以表名称快捷搜索枚举类型。
 * 例如：UserOfGender(YH_USER),这样做可能存在枚举名称太长，但搜索和使用方便，因为存在有规律。
 * 
 * 请在下方自行增加枚举类型，不要任意删除别人定义的枚举类型.
 * 
 * @author 	malei
 * @date 	2016年4月30日
 * @version 1.0.0
 */
public final class EnumConstants extends EnumMethod {


	// 定义用户基础表中的用户类型枚举值（YH_USER）
	public enum UserOfType implements IEnum {

		student(1, "学生用户"), parent(2, "家长用户"), org(3, "机构用户");

		// 枚举值
		private final int key;

		// 枚举描述
		private final String desc;


		private UserOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义用户基础表中的用户状态（YH_USER）
	public enum UserOfStatus implements IEnum {

		purpose(1, "意向"), tries(2, "试听"), normal(3, "正式"), quit(4, "离职"), frozen(5, "冻结"), del(6, "删除"), stop(7, "停课"), drop(
				8, "退学"), qormal(9, "准正式");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义用户基础表角色枚举类型（YH_USER）
	public enum UserOfRole implements IEnum {

		superAdmin(1, "总校校长"), admin(2, "分校校长"), teaching(3, "教职人员");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserOfRole( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义学生信息表中性别枚举(YH_USER_STUDENT)
	public enum UserStudentOfGender implements IEnum {

		MALE(1, "男"), FEMALE(2, "女");

		// 枚举值
		private final int key;

		// 枚举描述
		private final String desc;


		private UserStudentOfGender( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义用户学生表中的在线课程枚举（YH_USER_STUDENT）
	public enum UserStudentOfOnline implements IEnum {

		normal(1, "正常"), freeze(2, "冻结"), no(3, "未开通");

		// 枚举类型
		private final int key;

		// 枚举值
		private final String desc;


		private UserStudentOfOnline( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义家长信息表中的家长类型枚举类型（YH_USER_PARENT）
	public enum UserParentOfType implements IEnum {

		mother(1, "母亲"), father(2, "父亲"), other(3, "其他");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserParentOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义机构的部门类型枚举类型（YH_DEPARTMENT）
	public enum DepartmentOfType implements IEnum {

		superSchool(1, "总部"), school(2, "分部"), department(3, "部门");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private DepartmentOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义员工部门关系表中的部门状态枚举类型（YH_USER_DEPARTMENT_REL）
	public enum UserDepartmentRelOfStatus implements IEnum {

		normal(1, "正常"), del(2, "删除");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserDepartmentRelOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义员工职位关系表中的记录状态的枚举类型（YH_USER_POSITION_REL）
	public enum UserPositionRelOfStatus implements IEnum {

		normal(1, "正常状态"), del(2, "删除状态");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserPositionRelOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义员工教学关系表中的对象类型枚举类型（YH_USER_TEACHING_REL）
	public enum UserTeachingRelOfType implements IEnum {

		phase(1, "学段"), subject(2, "学科");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserTeachingRelOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义员工教学关系表中的对象状态枚举类型（YH_USER_TEACHING_REL）
	public enum UserTeachingRelOfStatus implements IEnum {

		normal(1, "正常状态"), del(2, "删除状态");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserTeachingRelOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义菜单表菜单类型枚举类型值（YH_MENU）
	public enum MenuOfType implements IEnum {

		first(1, "一级菜单"), second(2, "二级菜单");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private MenuOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义机构职位表中的职位状态枚举类型（YY_ORG_POSITION）
	public enum OrgPositionOfStatus implements IEnum {

		normal(1, "正常状态"), del(2, "删除状态");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgPositionOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义机构职位表中的职位类型枚举类型（YY_ORG_POSITION）
	public enum OrgPositionOfType implements IEnum {

		system(1, "系统类型"), custom(2, "自定义类型");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgPositionOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义机构参数信息表中的参数状态枚举类型(YY_ORG_ARGUMENT)
	public enum OrgArgumentOfStatus implements IEnum {

		normal(1, "正常状态"), del(2, "删除状态");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgArgumentOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义机构参数信息表中的参数类别枚举类型（YY_ORG_ARGUMENT）
	public enum OrgArgumentOfCategory implements IEnum {

		timeSegment(1, "开课时间段"),
		//
		clientStatus(2, "客户状态"),
		//
		communStyle(3, "沟通方式"),
		//
		tries(4, "试听状态"),
		//
		source(5, "招生来源"),
		//
		studentStatus(6, "学员状态"),
		//
		absence(7, "缺勤原因"),
		//
		timeLength(8, "开课时间长度"),
		//
		courseType(9, "课程类型"),
		//
		year(10, "开课年份"),
		//
		holiday(11, "节假日");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgArgumentOfCategory( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义机构参数信息表中的参数类型枚举类型（YY_ORG_ARGUMENT）
	public enum OrgArgumentOfType implements IEnum {

		system(1, "系统参数"), custom(2, "自定义参数");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgArgumentOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义机构教室表中的教室状态枚举类型（YY_ORG_CLASSROOM）
	public enum OrgClassroomOfStatus implements IEnum {

		normal(1, "正常状态"), del(2, "删除状态");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgClassroomOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义机构微信菜单表中的菜单类别枚举类型（YY_ORG_WEIXIN_MENU）
	public enum OrgWeixinMenuOfCategory implements IEnum {

		message(1, "消息类型"), url(2, "链接类型");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgWeixinMenuOfCategory( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义机构微信菜单表中的菜单类型枚举类型(YY_ORG_WEIXIN_MENU)
	public enum OrgWeixinMenuOfType implements IEnum {

		first(1, "一级菜单"), second(2, "二级菜单");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgWeixinMenuOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义员工业务关系表中的业务类型枚举类型（YH_USER_EMPLOYEE_PERFORMANCE_REL）
	public enum UserEmployeePerformanceRelOfType implements IEnum {

		purpose(1, "意向学员"), formal(2, "正式学员");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserEmployeePerformanceRelOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义订单表中的开课类型枚举类型（YH_USER_ORDER）
	public enum UserOrderOfCategory implements IEnum {

		first(1, "新开课"), renew(2, "续费"), add(3, "扩科");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserOrderOfCategory( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义订单表中的订单类型枚举类型（YH_USER_ORDER）
	public enum UserOrderOfType implements IEnum {

		PC(1, "PC端订单"), mobile(2, "移动端订单"), cooperation(3, "第三方合作订单");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserOrderOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义订单表中的订单状态枚举类型（ YH_USER_ORDER）
	public enum UserOrderOfStatus implements IEnum {

		unpay(1, "未支付"), payed(2, "已支付"), cancel(3, "已取消");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserOrderOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义订单表中的在线课程状态枚举（YH_USER_ORDER）
	public enum UserOrderOfOnline implements IEnum {

		yes(1, "已开通"), no(2, "未开通"), ;

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserOrderOfOnline( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义系统参数表中的参数类型枚举类型（YY_SYSTEM_ARGUMENT）
	public enum SystemArgumentOfType implements IEnum {

		phase(1, "学段"), grade(2, "年级"), subject(3, "学科"), course(4, "课程类型");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private SystemArgumentOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义系统参数表中的参数状态枚举类型（YY_SYSTEM_ARGUMENT）
	public enum SystemArgumentOfStatus implements IEnum {

		normal(1, "正常状态"), del(2, "删除状态");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private SystemArgumentOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义用户收藏表中的收藏类型枚举类型（YH_USER_COLLECTION）
	public enum UserCollectionOfType implements IEnum {

		course(1, "课程"), paper(2, "试卷"), exam(3, "试题"), video(4, "视频");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserCollectionOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义用户在线开课记录表中的会员类型枚举类型（YH_USER_ONLINE_COURSE_RECORD）
	public enum UserOnlineCourseRecordOfType implements IEnum {

		month(1, "按月"), quarter(2, "按季度"), halfYear(3, "按半年"), year(4, "按全年");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserOnlineCourseRecordOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义用户在线开课记录表中的账号状态枚举类型（YH_USER_ONLINE_COURSE_RECORD）
	public enum UserOnlineCourseRecordOfStatus implements IEnum {

		outOfDate(1, "已过期"), normal(2, "正常使用");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserOnlineCourseRecordOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义课程表中的课程状态枚举类型（JW_COURSE）
	public enum CourseOfStatus implements IEnum {

		using(1, "启用"), stop(2, "停用");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private CourseOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义用户班群信息表中的用户状态枚举类型（YH_USER_CLASS_GROUP）
	public enum UserClassGroupOfStatus implements IEnum {

		normal(1, "正常状态"), del(2, "删除状态"), stop(3, "停课"), drop(4, "退学");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserClassGroupOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义用户班群信息表中的班群类型枚举类型（YH_USER_CLASS_GROUP）
	public enum UserClassGroupOfType implements IEnum {

		student(1, "学生班群"), parent(2, "家长班群"), employee(3, "员工班群");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserClassGroupOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义班级教职人员表中的教职人员类型枚举类型（JW_CLASS_TEACHER）
	public enum ClassTeacherOfType implements IEnum {

		teacher(1, "任课教师"), assistant(2, "助教"), classTeacher(3, "班主任");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private ClassTeacherOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义用户签到表中的签到类型枚举类型（YH_USER_CHECK_IN）
	public enum UserCheckInOfType implements IEnum {

		arrived(1, "到校"), leave(2, "离校");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserCheckInOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义班级表中的班级状态枚举类型（JW_CLASS）
	public enum ClassOfClassStatus implements IEnum {

		unComplete(1, "未结业"), completed(2, "已结业"), del(3, "已删除");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private ClassOfClassStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义班级表中的排课状态枚举类型（JW_CLASS）
	public enum ClassOfSchStatus implements IEnum {

		unScheduling(1, "未排课"), schedulingNPublic(2, "已排课未发布"), schedulingYPublic(3, "已排课已发布");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private ClassOfSchStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义课程分发记录表中的分发状态枚举类型（ZY_COURSE_DISPENSE_RECORD）
	public enum CourseDispenseRecordOfIsAll implements IEnum {

		yes(1, "是"), no(2, "否");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private CourseDispenseRecordOfIsAll( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}
	}

	// 定义课程分发记录表中的分发状态枚举类型（ZY_COURSE_DISPENSE_RECORD）
	public enum CourseDispenseRecordOfStatus implements IEnum {

		unfinish(1, "未完成"), finished(2, "已完成");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private CourseDispenseRecordOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}
	}

	// 定义课程分发学生记录表中的分发状态枚举类型（ZY_COURSE_DISPENSE_STUDENT_RECORD）
	public enum CourseDispenseStudentRecordOfDispenseStatus implements IEnum {

		unfinish(1, "未完成"), finished(2, "已完成");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private CourseDispenseStudentRecordOfDispenseStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义课程分发学生记录表中的消费状态枚举类型（ZY_COURSE_DISPENSE_STUDENT_RECORD）
	public enum CourseDispenseStudentRecordOfConsumeStatus implements IEnum {

		unConsume(1, "未消费"), consumed(2, "已消费");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private CourseDispenseStudentRecordOfConsumeStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义用户调课记录表中的调课类型枚举类型（YH_USER_COURSE_ADJUST_RECORD）
	public enum UserCourseAdjustRecordOfType implements IEnum {

		drop(1, "退课"), stop(2, "停课"), restart(3, "复课");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserCourseAdjustRecordOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义资源操作记录表中的用户类型枚举类型（TJ_RESOURCE_OP_RECORD）
	public enum ResourceOpRecordOfUserType implements IEnum {

		student(1, "学生用户"), teacher(2, "教师用户");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private ResourceOpRecordOfUserType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义资源操作记录表中的资源类型枚举类型（TJ_RESOURCE_OP_RECORD）
	public enum ResourceOpRecordOfResourceType implements IEnum {

		exam(1, "试题"), paper(2, "试卷"), group(3, "课程组"), video(4, "视频");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private ResourceOpRecordOfResourceType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义资源操作记录表中的操作类型枚举类型（TJ_RESOURCE_OP_RECORD）
	public enum ResourceOpRecordOfType implements IEnum {

		down(1, "下载"), print(2, "打印");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private ResourceOpRecordOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义机构基础参数表中的参数类型枚举类型（YY_ORG_BASE_CODE）
	public enum OrgBaseCodeOfType implements IEnum {

		phase(7, "学段"), grade(1, "年级"), subject(2, "学科");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgBaseCodeOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义机构基础参数表中的参数状态枚举类型（YY_ORG_BASE_CODE）
	public enum OrgBaseCodeOfStatus implements IEnum {

		normal(1, "正常状态"), del(2, "删除状态");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgBaseCodeOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义机构基础参数表中的参数类别枚举类型（YY_ORG_BASE_CODE）
	public enum OrgBaseCodeOfCategory implements IEnum {

		system(1, "系统定义参数"), org(2, "机构定义参数");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgBaseCodeOfCategory( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义系统点评模板信息表中的模板类型枚举类型（YY_COMMENT_TEMPLATE）
	public enum CommentTemplateOfTempType implements IEnum {

		teacher(1, "点评老师的模板"), org(2, "点评机构的模板");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private CommentTemplateOfTempType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义系统点评模板表中的问卷点评对象类型枚举类型（YY_COMMENT_TEMPLATE）
	public enum CommentTemplateOfCommType implements IEnum {

		teacher(1, "任课老师"), classTeacher(2, "班主任"), org(3, "培训机构");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private CommentTemplateOfCommType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义系统点评模板表中的问卷发送对象类型枚举类型（YY_COMMENT_TEMPLATE）
	public enum CommentTemplateOfSendType implements IEnum {

		student(1, "学生"), parent(2, "家长"), both(3, "学生家长");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private CommentTemplateOfSendType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义点评模板标签表中的标签类型枚举类型（YY_COMMENT_TEMPLATE_TAG）
	public enum CommentTemplateTagOfType implements IEnum {

		one(1, "1星"), two(2, "2星"), three(3, "3星"), four(4, "4星"), five(5, "5星");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private CommentTemplateTagOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义系统点评模板发送频率表中的点评频率类型枚举类型（YY_COMMENT_TEMPLATE_SEND_RATE）
	public enum CommentTemplateSendRateOfType implements IEnum {

		firstend(1, "第一节课结束"), halfOfAll(2, "全部课程的一半"), end(3, "课程结束"), perweek(4, "每周一次"), permonth(5, "每月一次"), twicemonth(
				6, "每月两次");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private CommentTemplateSendRateOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义机构点评发送规则表中的周类型枚举类型（YY_ORG_COMMENT_TEMPLATE_SEND_RULE）
	public enum OrgCommentTemplateSendRuleOfWeekType implements IEnum {

		monday(1, "周一"), tuesday(2, "周二"), wednesday(3, "周三"), thursday(4, "周四"), friday(5, "周五"), saturday(6, "周六"), sunday(
				7, "周日");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgCommentTemplateSendRuleOfWeekType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}
	}

	// 定义机构点评发送规则表中的发送对象类型枚举类型（YY_ORG_COMMENT_TEMPLATE_SEND_RULE）
	public enum OrgCommentTemplateSendRuleOfSendObj implements IEnum {

		student(1, "学生"), parent(2, "家长"), both(3, "学生家长");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgCommentTemplateSendRuleOfSendObj( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义机构点评发送规则表中的任务开启状态枚举类型（YY_ORG_COMMENT_TEMPLATE_SEND_RULE）
	public enum OrgCommentTemplateSendRuleOfStatus implements IEnum {

		close(1, "关闭"), open(2, "开启");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgCommentTemplateSendRuleOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义用户评价信息表中的点评人身份枚举类型（YY_USER_COMMENT_RECORD）
	public enum UserCommentRecordOfUserType implements IEnum {

		student(1, "学生"), parent(2, "家长");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserCommentRecordOfUserType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义用户评价信息表中的对象类型枚举类型（YY_USER_COMMENT_RECORD）
	public enum UserCommentRecordOfObjType implements IEnum {

		teacher(1, "任课老师"), classTeacher(2, "班主任"), org(3, "机构");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserCommentRecordOfObjType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	public enum PersonalUserOfStatus implements IEnum {

		normal(1, "正常"), blackList(2, "黑名单");

		// 枚举值
		private final int key;

		// 枚举描述
		private final String desc;


		private PersonalUserOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义错题本表中的试题状态枚举（ZY_WRONG_EXAM_RECORD）
	public enum WrongExamRecordOfStatus implements IEnum {

		normal(1, "正常状态"), remove(2, "移除状态");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private WrongExamRecordOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义用户答题记录表中的是否正确枚举类型（ZY_USER_VIDEO_EXAM_RECORD）
	public enum UserVideoExamRecordOfIsRight implements IEnum {

		error(1, "错误"), right(2, "正确");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserVideoExamRecordOfIsRight( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义班级排课记录表中的记录状态枚举类型(JW_CLASS_COURSE_SCHEDULEING)
	public enum ClassCourseScheduleingOfStatus implements IEnum {

		normal(1, "正常状态"), del(2, "删除状态"), ;

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private ClassCourseScheduleingOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义操作状态
	public enum ActionOfStatus implements IEnum {

		delbatch(1, "批量删除"), changeformal(2, "转为正式学员"), changetries(3, "转为试听学员"), changepurposes(4, "转为意向学员"), importformal(
				5, "从意向学员导入到正式学员"), studrop(6, "退学操作");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private ActionOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义机构表中的机构类型枚举类型（YY_ORG）
	public enum OrgOfType implements IEnum {

		office(1, "工作室"), school(2, "学校"), company(3, "公司");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义机构表中的机构证件类型枚举类型（YY_ORG）
	public enum OrgOfPaperType implements IEnum {

		idCard(1, "身份证"), passport(2, "护照"), license(3, "办学许可证"), orgCode(4, "组织机构代码"), businessLicense(5, "营业执照");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private OrgOfPaperType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义建议反馈表中的反馈来源枚举类型（YY_SUGGEST_FEEDBACK）
	public enum SuggestFeedbackOfSourceType implements IEnum {

		app(1, "app端"), web(2, "web端");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private SuggestFeedbackOfSourceType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 微信素材类型（WX_MEDIA)
	public enum MediaTypeOfEnum implements IEnum {


		img(1, "img"),

		voice(2, "voice"),

		video(3, "video"),

		news(4, "news");

		private final int key;

		// 枚举描述
		private final String desc;


		MediaTypeOfEnum( final int key, final String desc ) {
			this.key = key;
			this.desc = desc;
		}


		public static MediaTypeOfEnum valueOf( int value ) {
			switch ( value ) {
				case 1 :
					return img;
				case 2 :
					return voice;
				case 3 :
					return video;
				case 4 :
					return news;
				default:
					return null;
			}
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}


	}

	// 微信永久临时素材类型（WX_MEDIA)
	public enum MediaMediaTypeOfEnum implements IEnum {


		temp(1, "temp"),

		forever(2, "forever");


		private final int key;

		// 枚举描述
		private final String desc;


		MediaMediaTypeOfEnum( final int key, final String desc ) {
			this.key = key;
			this.desc = desc;
		}


		public static MediaMediaTypeOfEnum valueOf( int value ) {
			switch ( value ) {
				case 1 :
					return temp;
				case 2 :
					return forever;
				default:
					return null;
			}
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	public enum UserDataOfUserSource implements IEnum {

		total(0, "total"),

		search(1, "temp"),

		cardShare(17, "cardShare"),

		scanCode(30, "scanCode"),

		rightMeun(43, "rightMenu"),

		pay(51, "pay"),

		news(57, "news"),

		ad(75, "ad"),

		friendShow(78, "firendShow");


		private final int key;

		// 枚举描述
		private final String desc;


		UserDataOfUserSource( final int key, final String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}
	}

	// 定义看课记录查询条件枚举
	public enum ChoiceOfCourseRecord implements IEnum {

		all(0, "全部"), seven(1, "7天"), thirty(2, "30天"), ninety(3, "90天");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private ChoiceOfCourseRecord( final int key, final String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


	// 定义用户班级作业操作记录表中的操作来源(JW_USER_SCHEDULING_HOMEWORK_RECORD)
	public enum UserSchedulingHomeWorkRecordOfSourceType implements IEnum {

		pc(1, "PC端"), weixin(2, "微信端"), app(3, "app端");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private UserSchedulingHomeWorkRecordOfSourceType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义用户班级作业操作记录表中的操作来源(JW_USER_SCHEDULING_HOMEWORK_RECORD)
	public enum IsBindWXType implements IEnum {

		unbound(0, "未绑定"), binding(1, "绑定中");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private IsBindWXType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义固定科目枚举
	public enum Subject implements IEnum {

		Chinese(21, "语文"), Math(22, "数学"), English(23, "英语"), Physical(24, "物理"), Chymistry(25, "化学"), Biology(26, "生物"), History(
				27, "历史"), Geography(28, "地理"), Political(29, "政治");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private Subject( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义固定阶段枚举
	public enum Phase implements IEnum {

		highSchool(51, "高中"), middleSchool(52, "初中");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private Phase( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义分发课程表中课程类型枚举类型（ZY_DISPENSE_COURSE_RECORD）
	public enum DispenseCourseRecordOfCourseType implements IEnum {

		wsubject(1, "微课程专题课"), wsyn(2, "微课程同步课"), msubject(3, "慕课专题课"), msyn(4, "慕课同步课"), video(5, "视频课程");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private DispenseCourseRecordOfCourseType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义课程查询类型枚举,微课,慕课都用到
	public enum LessonType implements IEnum {

		k1(1, "知识点"), vers(2, "教材版本");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private LessonType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义app版本更新表中app角色类型枚举类型（YY_APP_VERSION）
	public enum AppVersionOfType implements IEnum {

		student(1, "学生端");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private AppVersionOfType( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义app版本更新表中app端类型枚举类型（YY_APP_VERSION）
	public enum AppVersionOfCategory implements IEnum {

		android(1, "安卓"), ios(2, "苹果");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private AppVersionOfCategory( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}

	// 定义app版本更新表中app更新状态枚举类型（YY_APP_VERSION）
	public enum AppVersionOfStatus implements IEnum {

		no(1, "失效"), yes(2, "生效");

		// 枚举类型
		private final int key;

		// 枚举描述
		private final String desc;


		private AppVersionOfStatus( int key, String desc ) {
			this.key = key;
			this.desc = desc;
		}


		@Override
		public int key() {
			return key;
		}


		@Override
		public String desc() {
			return desc;
		}

	}


}
