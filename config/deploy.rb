set :application, 'ngtouch'

set :repo_url, 'git@github.com:seance/ngtouch-deploy.git'
set :scm, :git
set :branch, 'master'

# ask :branch, proc { `git rev-parse --abbrev-ref HEAD`.chomp }

set :deploy_to, '~/ngtouch'

# set :format, :pretty
# set :log_level, :debug
# set :pty, true

# set :linked_files, %w{config/database.yml}
# set :linked_dirs, %w{bin log tmp/pids tmp/cache tmp/sockets vendor/bundle public/system}

# set :default_env, { path: "/opt/ruby/bin:$PATH" }
# set :keep_releases, 5

namespace :deploy do

  desc 'Restart application'
  task :restart do
    on roles(:web), in: :sequence, wait: 5 do
      # Your restart mechanism here, for example:
      # execute :touch, release_path.join('tmp/restart.txt')
      execute :touch, release_path.join('RESTART')
    end
  end

#   after :restart, :clear_cache do
#     on roles(:web), in: :groups, limit: 3, wait: 10 do
#       # Here we can do anything such as:
#       # within release_path do
#       #   execute :rake, 'cache:clear'
#       # end
#     end
#   end
# 
#   after :finishing, 'deploy:cleanup'
# 
end