# GIT版本控制笔记

## 1.基础命令

```
初始化用户名
$ git config --global user.name 'use1'
初始化用户名邮箱
$ git config --global user.email 'zyp5930@163.com'
初始化一个新仓库
git init：生成.git文件 

git add +文件：将工作区的文件提交到暂存区
git commit -m“注释”：将暂存区的文件提交到Git仓库

git diff +文件：查看修改的内容
git status ：查看文件状态
git log --pretty=oneline：显示历史修改记录
git reset --hard HEAD^：退回上一个版本
git reset --hard 66712ec...（版本号）：跳转到对应的版本
git reflog：查看命令的历史记录

git checkout -- +文件：把这个文件在工作区的修改全部撤销（--要记得加上）
git reset HEAD +文件：把暂存区修改的撤销掉，放回工作区

git rm+文件：确定要删除工作区的文件
```



## 2.分支管理常用命令

```git

git branch + 分支名：创建分支
git checkout +分支名：切换分支
git checkout -b +分支名：创建并切换分支

git branch：查看当前分支

git merge +分支名：合并指定分支到当前分支（重要）
git merge --no-ff -m "注释" dev：禁用fast forward快速合并模式

git branch --merged #查看那些分支已经合并到当前分支
git branch --no-merged #查看哪些分支尚未合并到当前分支

git branch -d +分支名：删除分支
git branch -D +分支名：删除没有被合并过的分支

git log --graph --pretty=oneline --abbrev-commit：显示分支合并图

关于BUG分支的一般处理方法：
git stash：将工作现场储存起来
git stash list：查看工作现场存储的地方

git stash apply：恢复被储存的现场
git stash drop：删除stash
git stash pop：恢复现场的同时删除stash内容（常用）

git cherry-pick+<提交BUG修改的commit id>：复制一个特定的提交到当前分支（避免重复劳动）
```

