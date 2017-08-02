# Github Explorer App
Android app to explore random Github users written in `Kotlin`

## Overview

This is an example of a simple Android App using:
- Retrofit
- RxAndroid
- `RecyclerView`s and `CardView`s

## About REST API
We use two public endpoints of Github in the class `GithubService`:

### /users
It a list of users registered in Github.

Response example:
https://api.github.com/users/since=230
```json
[  
   {  
      login:"jhardy-deleteme",
      id:231,
      avatar_url:"https://avatars3.githubusercontent.com/u/231?v=4",
      gravatar_id:"",
      url:"https://api.github.com/users/jhardy-deleteme",
      html_url:"https://github.com/jhardy-deleteme",
      followers_url:"https://api.github.com/users/jhardy-deleteme/followers",
      following_url:"https://api.github.com/users/jhardy-deleteme/following{/other_user}",
      gists_url:"https://api.github.com/users/jhardy-deleteme/gists{/gist_id}",
      starred_url:"https://api.github.com/users/jhardy-deleteme/starred{/owner}{/repo}",
      subscriptions_url:"https://api.github.com/users/jhardy-deleteme/subscriptions",
      organizations_url:"https://api.github.com/users/jhardy-deleteme/orgs",
      repos_url:"https://api.github.com/users/jhardy-deleteme/repos",
      events_url:"https://api.github.com/users/jhardy-deleteme/events{/privacy}",
      received_events_url:"https://api.github.com/users/jhardy-deleteme/received_events",
      type:"User",
      site_admin:false
   },
   {  
      login:"daikini",
      id:232,
      avatar_url:"https://avatars3.githubusercontent.com/u/232?v=4",
      gravatar_id:"",
      url:"https://api.github.com/users/daikini",
      html_url:"https://github.com/daikini",
      followers_url:"https://api.github.com/users/daikini/followers",
      following_url:"https://api.github.com/users/daikini/following{/other_user}",
      gists_url:"https://api.github.com/users/daikini/gists{/gist_id}",
      starred_url:"https://api.github.com/users/daikini/starred{/owner}{/repo}",
      subscriptions_url:"https://api.github.com/users/daikini/subscriptions",
      organizations_url:"https://api.github.com/users/daikini/orgs",
      repos_url:"https://api.github.com/users/daikini/repos",
      events_url:"https://api.github.com/users/daikini/events{/privacy}",
      received_events_url:"https://api.github.com/users/daikini/received_events",
      type:"User",
      site_admin:false
   },
   // ...
]
```

### /users/{user}/repos
We use this endpoint to show user's repositories information.

Response example for https://api.github.com/users/jhardy-deleteme/repos
```json
[  
   {  
      id:4473,
      name:"chunky_bacon",
      full_name:"daikini/chunky_bacon",
      owner:{  
         login:"daikini",
         id:232,
         avatar_url:"https://avatars3.githubusercontent.com/u/232?v=4",
         gravatar_id:"",
         url:"https://api.github.com/users/daikini",
         html_url:"https://github.com/daikini",
         followers_url:"https://api.github.com/users/daikini/followers",
         following_url:"https://api.github.com/users/daikini/following{/other_user}",
         gists_url:"https://api.github.com/users/daikini/gists{/gist_id}",
         starred_url:"https://api.github.com/users/daikini/starred{/owner}{/repo}",
         subscriptions_url:"https://api.github.com/users/daikini/subscriptions",
         organizations_url:"https://api.github.com/users/daikini/orgs",
         repos_url:"https://api.github.com/users/daikini/repos",
         events_url:"https://api.github.com/users/daikini/events{/privacy}",
         received_events_url:"https://api.github.com/users/daikini/received_events",
         type:"User",
         site_admin:false
      },
      private:false,
      html_url:"https://github.com/daikini/chunky_bacon",
      description:"MountainWest RubyConf 2008 Presentation",
      fork:false,
      url:"https://api.github.com/repos/daikini/chunky_bacon",
      forks_url:"https://api.github.com/repos/daikini/chunky_bacon/forks",
      keys_url:"https://api.github.com/repos/daikini/chunky_bacon/keys{/key_id}",
      collaborators_url:"https://api.github.com/repos/daikini/chunky_bacon/collaborators{/collaborator}",
      teams_url:"https://api.github.com/repos/daikini/chunky_bacon/teams",
      hooks_url:"https://api.github.com/repos/daikini/chunky_bacon/hooks",
      issue_events_url:"https://api.github.com/repos/daikini/chunky_bacon/issues/events{/number}",
      events_url:"https://api.github.com/repos/daikini/chunky_bacon/events",
      assignees_url:"https://api.github.com/repos/daikini/chunky_bacon/assignees{/user}",
      branches_url:"https://api.github.com/repos/daikini/chunky_bacon/branches{/branch}",
      tags_url:"https://api.github.com/repos/daikini/chunky_bacon/tags",
      blobs_url:"https://api.github.com/repos/daikini/chunky_bacon/git/blobs{/sha}",
      git_tags_url:"https://api.github.com/repos/daikini/chunky_bacon/git/tags{/sha}",
      git_refs_url:"https://api.github.com/repos/daikini/chunky_bacon/git/refs{/sha}",
      trees_url:"https://api.github.com/repos/daikini/chunky_bacon/git/trees{/sha}",
      statuses_url:"https://api.github.com/repos/daikini/chunky_bacon/statuses/{sha}",
      languages_url:"https://api.github.com/repos/daikini/chunky_bacon/languages",
      stargazers_url:"https://api.github.com/repos/daikini/chunky_bacon/stargazers",
      contributors_url:"https://api.github.com/repos/daikini/chunky_bacon/contributors",
      subscribers_url:"https://api.github.com/repos/daikini/chunky_bacon/subscribers",
      subscription_url:"https://api.github.com/repos/daikini/chunky_bacon/subscription",
      commits_url:"https://api.github.com/repos/daikini/chunky_bacon/commits{/sha}",
      git_commits_url:"https://api.github.com/repos/daikini/chunky_bacon/git/commits{/sha}",
      comments_url:"https://api.github.com/repos/daikini/chunky_bacon/comments{/number}",
      issue_comment_url:"https://api.github.com/repos/daikini/chunky_bacon/issues/comments{/number}",
      contents_url:"https://api.github.com/repos/daikini/chunky_bacon/contents/{+path}",
      compare_url:"https://api.github.com/repos/daikini/chunky_bacon/compare/{base}...{head}",
      merges_url:"https://api.github.com/repos/daikini/chunky_bacon/merges",
      archive_url:"https://api.github.com/repos/daikini/chunky_bacon/{archive_format}{/ref}",
      downloads_url:"https://api.github.com/repos/daikini/chunky_bacon/downloads",
      issues_url:"https://api.github.com/repos/daikini/chunky_bacon/issues{/number}",
      pulls_url:"https://api.github.com/repos/daikini/chunky_bacon/pulls{/number}",
      milestones_url:"https://api.github.com/repos/daikini/chunky_bacon/milestones{/number}",
      notifications_url:"https://api.github.com/repos/daikini/chunky_bacon/notifications{?since,all,participating}",
      labels_url:"https://api.github.com/repos/daikini/chunky_bacon/labels{/name}",
      releases_url:"https://api.github.com/repos/daikini/chunky_bacon/releases{/id}",
      deployments_url:"https://api.github.com/repos/daikini/chunky_bacon/deployments",
      created_at:"2008-03-19T01:10:27Z",
      updated_at:"2017-07-25T13:13:23Z",
      pushed_at:"2008-03-28T20:34:10Z",
      git_url:"git://github.com/daikini/chunky_bacon.git",
      ssh_url:"git@github.com:daikini/chunky_bacon.git",
      clone_url:"https://github.com/daikini/chunky_bacon.git",
      svn_url:"https://github.com/daikini/chunky_bacon",
      homepage:"",
      size:2800,
      stargazers_count:5,
      watchers_count:5,
      language:"JavaScript",
      has_issues:true,
      has_projects:true,
      has_downloads:true,
      has_wiki:true,
      has_pages:false,
      forks_count:0,
      mirror_url:null,
      open_issues_count:0,
      forks:0,
      open_issues:0,
      watchers:5,
      default_branch:"master"
   },
   // ...
]
```

## Screenshots
![api-example-v2](https://user-images.githubusercontent.com/1646576/28874722-6fa1da2c-7769-11e7-902b-301838489757.gif)

## Related links
- [Kotlin Syntax Reference](https://kotlinlang.org/docs/reference/basic-syntax.html)
- [Android Recycler View](https://www.raywenderlich.com/126528/android-recyclerview-tutorial)
- [Consuming REST with Retrofit and RxAndroid](https://kmangutov.wordpress.com/2015/03/28/android-mvp-consuming-restful-apis/)
- [Retrofit Github Repository](https://github.com/square/retrofit)
- [RecyclerView with cardview using Kotlin in Android](http://ktutorials.com/kotlin/recyclerview-with-cardview-using-kotlin-in-android/)
- [Android working with Card View and Recycler View](https://www.androidhive.info/2016/05/android-working-with-card-view-and-recycler-view/)

## Thanks to the Restorando Android Team
- [@pato94](https://github.com/pato94)
- [@garispe](https://github.com/garispe)
- [@roddeluca](https://github.com/roddeluca)
